package com.agoni.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBaits 配置类
 *
 * @author AgoniMou
 * @since 2022-09-14
 */
@Configuration
public class MybatisAutoConfiguration {

    /**
     * 分页拦截器
     * @return 分页拦截器
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor()); // 分页插件
        return mybatisPlusInterceptor;
    }

    /**
     * 自动填充配置
     */
    @Bean
    public MetaObjectHandler defaultMetaObjectHandler() {
        return new MybatisPlusMetaObjectHandler(); // 自动填充参数类
    }
}
