package com.agoni.ip2region.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ip2region 自动化配置
 *
 * @author AgoniMou
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(Ip2regionProperties.class)
public class Ip2regionConfiguration {

//    @Bean
//    public Ip2regionSearcherService ip2regionSearcher(ResourceLoader resourceLoader,
//                                                      Ip2regionProperties properties) {
//        return new Ip2regionSearcherService(resourceLoader, properties);
//    }
}
