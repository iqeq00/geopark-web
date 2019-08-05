package com.geopark.web.shiro;

import com.geopark.framework.cons.APICons;
import com.geopark.framework.enums.ErrorCodeEnum;
import com.geopark.framework.utils.JWTUtils;
import com.geopark.framework.utils.ResponseUtils;
import com.geopark.web.model.vo.ResourcePermVo;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.PathMatcher;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.function.Predicate;

/**
 * JWT过滤器 适用于shiro
 *
 * @author lichee
 */
@Slf4j
public class JWTFilter extends BasicHttpAuthenticationFilter {

    private PathMatcher pathMatcher;
    private SysResourceService resourceService;
    private UrlPathHelper urlPathHelper;
    private String contextPath;

    /**
     * 这里重写了父类的方法，使用我们自己定义的Token类，提交给shiro。
     * 这个方法返回null的话会直接抛出异常，进入isAccessAllowed（）的异常处理逻辑。
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) {
        //获取请求token
        String token = getToken(WebUtils.toHttp(servletRequest));
        if (StringUtils.isBlank(token)) {
            return null;
        }
        return StringUtils.isBlank(token) ? null : new JWTToken(token);
    }

    /**
     * 执行登录认证
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        request.setAttribute(APICons.API_BEGIN_TIME, System.currentTimeMillis());
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        HttpServletResponse httpResponse = WebUtils.toHttp(response);

        String token = getToken(httpRequest);
        String method = httpRequest.getMethod();
        String requestUri = urlPathHelper.getOriginatingRequestUri(httpRequest);
        if (StringUtils.isNotEmpty(contextPath)) {
            requestUri = requestUri.replaceFirst(contextPath, "");
        }
        Optional<String> optional = resourceService.getResourcePerms(method)
                .stream()
                .filter(match(method, requestUri))
                .map(ResourcePermVo::getMapping)
                .min(pathMatcher.getPatternComparator(requestUri));
        request.setAttribute(APICons.API_REQURL, requestUri);
        request.setAttribute(APICons.API_METHOD, method);
        if (optional.isPresent()) {
            request.setAttribute(APICons.API_MAPPING, optional.get());
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return false;
        }
        if (Objects.isNull(token)) {
            List<ResourcePermVo> openPerms = resourceService.getOpenPerms();
            boolean match = anyMatch(openPerms, method, requestUri);
            if (!match) {
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
            return match;
        }
        if (isLoginRequest(request, response)) {
            if (executeLogin(request, response)) {
                Integer uid = JWTUtils.getUid(token);
                request.setAttribute(APICons.API_UID, uid);
                Set<ResourcePermVo> perms = resourceService.getUserResourcePerms(uid);
                return anyMatch(perms, method, requestUri);
            } else {
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return sendUnauthorizedFail(request, response);
            }
        }
        return false;

    }

    /**
     * 如果这个Filter在之前isAccessAllowed（）方法中返回false,则会进入这个方法。
     * 我们这里直接返回错误的response
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        switch (httpResponse.getStatus()) {
            case HttpServletResponse.SC_NOT_FOUND:
                return sendNotFoundFail(request, response);
            case HttpServletResponse.SC_UNAUTHORIZED:
                return sendUnauthorizedFail(request, response);
            default:
                return sendForbiddenFail(request, response);
        }
    }

    /**
     * 如果调用shiro的login认证失败，会回调这个方法，
     * 因为逻辑放到了onAccessDenied（）中。
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        return sendUnauthorizedFail(request, response);
    }

    /**
     * 获取请求的token
     */
    protected String getToken(HttpServletRequest request) {
        //从header中获取token
        String token = request.getHeader(AUTHORIZATION_HEADER);
        return StringUtils.isBlank(token) ? null : token.replaceFirst("Bearer ", "");
    }

    /**
     * 无权限
     */
    protected boolean sendForbiddenFail(ServletRequest request, ServletResponse response) {
        ResponseUtils.sendFail(WebUtils.toHttp(request), WebUtils.toHttp(response), ErrorCodeEnum.FORBIDDEN);
        return false;
    }

    /**
     * 路径不存在
     */
    protected boolean sendNotFoundFail(ServletRequest request, ServletResponse response) {
        ResponseUtils.sendFail(WebUtils.toHttp(request), WebUtils.toHttp(response), ErrorCodeEnum.NOT_FOUND);
        return false;
    }

    /**
     * 未认证
     */
    protected boolean sendUnauthorizedFail(ServletRequest request, ServletResponse response) {
        ResponseUtils.sendFail(WebUtils.toHttp(request), WebUtils.toHttp(response), ErrorCodeEnum.UNAUTHORIZED);
        return false;
    }


    /**
     * 是否任意匹配权限URL
     *
     * @param perms
     * @return
     */
    protected boolean anyMatch(Collection<ResourcePermVo> perms, String method, String requestUri) {
        return perms.stream().anyMatch(match(method, requestUri));
    }

    /**
     * 匹配请求方法与路径
     *
     * @param method
     * @param requestUri
     * @return
     */
    private Predicate<ResourcePermVo> match(String method, String requestUri) {
        return res -> res.getMethod().equalsIgnoreCase(method) && pathMatcher.match(res.getMapping(), requestUri);
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        try {
            return super.executeLogin(request, response);
        } catch (Exception ignored) {
        }
        return false;
    }

    public void setResourceService(SysResourceService resourceService) {
        this.resourceService = resourceService;
    }

    public void setPathMatcher(PathMatcher pathMatcher) {
        this.pathMatcher = pathMatcher;
    }

    public void setUrlPathHelper(UrlPathHelper urlPathHelper) {
        this.urlPathHelper = urlPathHelper;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
}