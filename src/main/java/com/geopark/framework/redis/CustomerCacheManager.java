package com.geopark.framework.redis;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.*;

import static com.google.common.collect.Sets.newHashSet;

public class CustomerCacheManager extends RedisCacheManager implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;
    private RedisCacheConfiguration defaultCacheConfig;
    Map<String, RedisCacheConfiguration> cacheConfigurationMap = Maps.newHashMap();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public CustomerCacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration) {
        super(cacheWriter, defaultCacheConfiguration);
        this.defaultCacheConfig = defaultCacheConfiguration;
    }

    @Override
    protected Collection<RedisCache> loadCaches() {
        List<RedisCache> caches = new LinkedList<>();
        Map<String, Long> cacheableExpireMap = parseCacheableExpire();
        cacheableExpireMap.forEach((key, value) -> {
            RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().entryTtl(defaultCacheConfig.getTtl()).serializeValuesWith(defaultCacheConfig.getValueSerializationPair());
            if (null != value) {
                redisCacheConfiguration.entryTtl(Duration.ofSeconds(value));
            }
            cacheConfigurationMap.put(key, redisCacheConfiguration);
        });
        for (Map.Entry<String, RedisCacheConfiguration> entry : cacheConfigurationMap.entrySet()) {
            caches.add(createRedisCache(entry.getKey(), entry.getValue()));
        }
        return caches;
    }

    private Map<String, Long> parseCacheableExpire() {

        final Map<String, Long> cacheableExpires = new HashMap<>();
        String[] beanNames = applicationContext.getBeanNamesForType(Object.class);
        for (String beanName : beanNames) {
            final Class clazz = applicationContext.getType(beanName);
            Service service = AnnotationUtils.findAnnotation(clazz, Service.class);
            if (null == service) {
                continue;
            }
            addCacheExpires(clazz, cacheableExpires);
        }
        return cacheableExpires;
    }

    private void addCacheExpires(final Class clazz, final Map<String, Long> cacheableExpires) {
        ReflectionUtils.doWithMethods(clazz, method -> {
            ReflectionUtils.makeAccessible(method);
            CacheableExpire cacheableExpire = findCacheDuration(clazz, method);
            Cacheable cacheable = AnnotationUtils.findAnnotation(method, Cacheable.class);
            CacheConfig cacheConfig = AnnotationUtils.findAnnotation(clazz, CacheConfig.class);
            Set<String> cacheNames = findCacheNames(cacheConfig, cacheable);
            cacheNames.forEach(cacheName -> cacheableExpires.put(cacheName, cacheableExpire.value()));
        }, method -> null != AnnotationUtils.findAnnotation(method, Cacheable.class));
    }

    /**
     * CacheDuration标注的有效期，优先使用方法上标注的有效期
     *
     * @param clazz
     * @param method
     * @return
     */
    private CacheableExpire findCacheDuration(Class clazz, Method method) {

        CacheableExpire methodCacheDuration = AnnotationUtils.findAnnotation(method, CacheableExpire.class);
        if (null != methodCacheDuration) {
            return methodCacheDuration;
        }
        CacheableExpire classCacheDuration = AnnotationUtils.findAnnotation(clazz, CacheableExpire.class);
        if (null != classCacheDuration) {
            return classCacheDuration;
        }
        return null;
    }

    private Set<String> findCacheNames(CacheConfig cacheConfig, Cacheable cacheable) {
        return StringUtils.isEmpty(cacheable.value()) ? newHashSet(cacheConfig.cacheNames()) : newHashSet(cacheable.value());
    }
}
