package com.agoni.ip2region.util;

import com.agoni.ip2region.core.IpInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Pattern;

import static com.agoni.core.constants.CommonConstant.STR_ZERO;

/**
 * 获取ip信息详情工具类
 *
 * @author AgoniMou
 * @since 2022-09-08
 */
public class IpInfoUtils {

    private static final Pattern SPLIT_PATTERN = Pattern.compile("\\|");

    /**
     * 将 DataBlock 转化为 IpInfo
     *
     * @param region region
     * @return IpInfo
     */
    @Nullable
    public static IpInfo toIpInfo(@Nullable String region) {
        if (region == null) {
            return null;
        }
        IpInfo ipInfo = new IpInfo();
        String[] splitInfos = SPLIT_PATTERN.split(region);
        // 补齐5位
        if (splitInfos.length < 5) {
            splitInfos = Arrays.copyOf(splitInfos, 5);
        }
        ipInfo.setCountry(filterZero(splitInfos[0]));
        ipInfo.setRegion(filterZero(splitInfos[1]));
        ipInfo.setProvince(filterZero(splitInfos[2]));
        ipInfo.setCity(filterZero(splitInfos[3]));
        ipInfo.setIsp(filterZero(splitInfos[4]));
        return ipInfo;
    }

    /**
     * 数据过滤，因为 ip2Region 采用 0 填充的没有数据的字段
     *
     * @param info info
     * @return info
     */
    @Nullable
    private static String filterZero(@Nullable String info) {
        // null 或 0 返回 null
        if (info == null || STR_ZERO.equals(info)) {
            return null;
        }
        return info;
    }

    /**
     * 读取 IpInfo
     *
     * @param ipInfo   IpInfo
     * @param function Function
     * @return info
     */
    @Nullable
    public static String readInfo(@Nullable IpInfo ipInfo, Function<IpInfo, String> function) {
        if (ipInfo == null) {
            return null;
        }
        return function.apply(ipInfo);
    }
}
