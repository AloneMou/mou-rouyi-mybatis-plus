package com.agoni.ip2region.service.impl;

import com.agoni.exception.ServerException;
import com.agoni.exception.enums.GlobalErrorCodeConstants;
import com.agoni.ip2region.config.Ip2regionProperties;
import com.agoni.ip2region.core.IpInfo;
import com.agoni.ip2region.service.Ip2regionSearcherService;
import com.agoni.ip2region.util.IpInfoUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@RequiredArgsConstructor
public class Ip2regionSearcherServiceImpl implements InitializingBean, DisposableBean, Ip2regionSearcherService {

    private final ResourceLoader resourceLoader;
    private final Ip2regionProperties properties;
    private Searcher searcher;

    @Override
    public IpInfo memorySearch(long ip) {
        try {
            return IpInfoUtils.toIpInfo(searcher.search(ip));
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new ServerException(GlobalErrorCodeConstants.UNKNOWN);
        }
    }

    @Override
    public IpInfo memorySearch(String ip) {
        try {
            return IpInfoUtils.toIpInfo(searcher.search(ip));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServerException(GlobalErrorCodeConstants.UNKNOWN);
        }
    }

    @Override
    public void destroy() throws Exception {
        if (this.searcher != null) {
            this.searcher.close();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Resource resource = resourceLoader.getResource(properties.getDbFileLocation());
        try (InputStream inputStream = resource.getInputStream()) {
            this.searcher = Searcher.newWithBuffer(StreamUtils.copyToByteArray(inputStream));
        }
    }
}
