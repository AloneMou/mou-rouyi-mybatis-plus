package com.agoni.protection.idempotent.config;

import com.agoni.protection.idempotent.core.aop.IdempotentAspect;
import com.agoni.protection.idempotent.core.keyresolver.IdempotentKeyResolver;
import com.agoni.protection.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import com.agoni.protection.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import com.agoni.protection.idempotent.core.redis.IdempotentRedisDAO;
import com.agoni.redis.config.CustomRedisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(CustomRedisAutoConfiguration.class)
public class CustomIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
