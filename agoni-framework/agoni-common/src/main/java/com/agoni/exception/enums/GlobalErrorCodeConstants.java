package com.agoni.exception.enums;

import com.agoni.exception.ResultCode;


/**
 * 全局错误码枚举
 * 0-999 系统异常编码保留
 *
 * 一般情况下，使用 HTTP 响应状态码 https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Status
 * 虽然说，HTTP 响应状态码作为业务使用表达能力偏弱，但是使用在系统层面还是非常不错的
 * 比较特殊的是，因为之前一直使用 0 作为成功，就不使用 200 啦。
 *
 * @author AgoniMou
 */
public interface GlobalErrorCodeConstants {

    ResultCode SUCCESS = new ResultCode(0, "成功");

    // ========== 客户端错误段 ==========
    ResultCode BAD_REQUEST = new ResultCode(400, "请求参数不正确");
    ResultCode UNAUTHORIZED = new ResultCode(401, "账号未登录");
    ResultCode FORBIDDEN = new ResultCode(403, "没有该操作权限");
    ResultCode NOT_FOUND = new ResultCode(404, "请求未找到");
    ResultCode METHOD_NOT_ALLOWED = new ResultCode(405, "请求方法不正确");
    ResultCode LOCKED = new ResultCode(423, "请求失败，请稍后重试"); // 并发请求，不允许
    ResultCode TOO_MANY_REQUESTS = new ResultCode(429, "请求过于频繁，请稍后重试");

    // ========== 服务端错误段 ==========
    ResultCode INTERNAL_SERVER_ERROR = new ResultCode(500, "系统异常");

    // ========== 自定义错误段 ==========
    ResultCode REPEATED_REQUESTS = new ResultCode(900, "重复请求，请稍后重试"); // 重复请求

    ResultCode UNKNOWN = new ResultCode(999, "未知错误");

    /**
     * 是否为服务端错误，参考 HTTP 5XX 错误码段
     *
     * @param code 错误码
     * @return 是否
     */
    static boolean isServerErrorCode(Integer code) {
        return code != null
                && code >= INTERNAL_SERVER_ERROR.getCode() && code <= INTERNAL_SERVER_ERROR.getCode() + 99;
    }
}
