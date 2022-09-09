package com.agoni.ip2region.service;

import com.agoni.ip2region.core.IpInfo;
import com.agoni.ip2region.util.IpInfoUtils;
import org.springframework.lang.Nullable;

import java.util.function.Function;

public interface Ip2regionSearcherService {


    /**
     * ip 位置 搜索
     *
     * @param ip ip
     * @return 位置
     */
    @Nullable
    IpInfo memorySearch(long ip);

    /**
     * ip 位置 搜索
     *
     * @param ip ip
     * @return 位置
     */
    @Nullable
    IpInfo memorySearch(String ip);

    /**
     * 读取 ipInfo 中的信息
     *
     * @param ip       ip
     * @param function Function
     * @return 地址
     */
    @Nullable
    default String getInfo(long ip, Function<IpInfo, String> function) {
        return IpInfoUtils.readInfo(memorySearch(ip), function);
    }

    /**
     * 读取 ipInfo 中的信息
     *
     * @param ip       ip
     * @param function Function
     * @return 地址
     */
    @Nullable
    default String getInfo(String ip, Function<IpInfo, String> function) {
        return IpInfoUtils.readInfo(memorySearch(ip), function);
    }

    /**
     * 获取地址信息
     *
     * @param ip ip
     * @return 地址
     */
    @Nullable
    default String getAddress(long ip) {
        return getInfo(ip, IpInfo::getAddress);
    }

    /**
     * 获取地址信息
     *
     * @param ip ip
     * @return 地址
     */
    @Nullable
    default String getAddress(String ip) {
        return getInfo(ip, IpInfo::getAddress);
    }

    /**
     * 获取地址信息包含 isp
     *
     * @param ip ip
     * @return 地址
     */
    @Nullable
    default String getFullAddress(long ip) {
        return getInfo(ip, IpInfo::getFullAddress);
    }

    /**
     * 获取地址信息包含 isp
     *
     * @param ip ip
     * @return 地址
     */
    @Nullable
    default String getFullAddress(String ip) {
        return getInfo(ip, IpInfo::getFullAddress);
    }
}
