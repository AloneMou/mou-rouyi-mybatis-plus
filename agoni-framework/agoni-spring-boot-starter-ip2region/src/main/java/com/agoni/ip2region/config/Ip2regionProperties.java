package com.agoni.ip2region.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Data
@ConfigurationProperties("agoni.ip2region")
public class Ip2regionProperties {

    /**
     * ip2region.db 文件路径
     */
    private String dbFileLocation = "classpath:ip2region/ip2region.xdb";
}
