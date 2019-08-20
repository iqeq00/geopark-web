package com.geopark.web.cpt;

import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.web.service.SysResourceService;
import com.geopark.framework.annotations.Resources;
import com.geopark.web.model.entity.SysResource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务mapping扫描
 * </p>
 *
 * @author lichee
 */
@Service
public class ScanMappings {

    @Autowired
    private SysResourceService resourceService;

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    private String[] emptyArray = new String[]{""};

    /**
     * 扫描资源插入数据库
     */
    @PostConstruct
    public void doScan() {
        resourceService.saveOrUpdateBatch(
                handlerMapping.getHandlerMethods()
                        .values()
                        .stream()
                        .map(this::getResources)
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList())
        );
    }

    /**
     * 获取Resource
     *
     * @param handlerMethod
     * @return
     */
    public List<SysResource> getResources(HandlerMethod handlerMethod) {

        Resources res = handlerMethod.getMethodAnnotation(Resources.class);
        if (Objects.isNull(res)) {
            return Collections.emptyList();
        }
        RequestMapping requestMappingAnnotation = handlerMethod.getBeanType().getAnnotation(RequestMapping.class);
        RequestMapping methodMappingAnnotation = handlerMethod.getMethodAnnotation(RequestMapping.class);
        if (Objects.isNull(requestMappingAnnotation) && Objects.isNull(methodMappingAnnotation)) {
            return Collections.emptyList();
        }
        ApiOperation apiOperation = handlerMethod.getMethodAnnotation(ApiOperation.class);
        String[] requestMappings = Objects.nonNull(requestMappingAnnotation) ? requestMappingAnnotation.value() : emptyArray;
        String[] methodMappings = Objects.nonNull(methodMappingAnnotation) ? methodMappingAnnotation.path() : emptyArray;
        RequestMethod[] method = Objects.nonNull(methodMappingAnnotation) ? methodMappingAnnotation.method() : new RequestMethod[0];
        requestMappings = ArrayUtils.isEmpty(requestMappings) ? emptyArray : requestMappings;
        methodMappings = ArrayUtils.isEmpty(methodMappings) ? emptyArray : methodMappings;
        Set<String> mappings = new HashSet<>(1);
        for (String reqMapping : requestMappings) {
            for (String methodMapping : methodMappings) {
                mappings.add(reqMapping + methodMapping);
            }
        }
        List<SysResource> resources = new ArrayList<>(1);
        for (RequestMethod requestMethod : method) {
            for (String mapping : mappings) {
                //接口描述
                SysResource resource = new SysResource();
                resource.setResourceName(apiOperation.value());
                resource.setMapping(mapping);
                resource.setMethod(requestMethod.name());
                resource.setAuthType(res.value());
                resource.setPerm(resourceService.getResourcePermTag(requestMethod.name(), mapping));
                resource.setId(DigestUtils.md5Hex(resource.getPerm()));
                resources.add(resource);
            }
        }
//        resources.forEach(resource -> {
//            System.out.println(resource.toString());
//        });
        return resources;
    }

}
