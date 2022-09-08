package com.agoni.ip2region.config;

import com.agoni.ip2region.service.Ip2regionSearcherService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;

/**
 * ip2region 自动化配置
 *
 * @author AgoniMou
 */
@EnableConfigurationProperties(Ip2regionProperties.class)
public class Ip2regionConfiguration {

    @Bean
    public Ip2regionSearcherService ip2regionSearcher(ResourceLoader resourceLoader,
                                                      Ip2regionProperties properties) {
        return new Ip2regionSearcherService(resourceLoader, properties);
    }
}
