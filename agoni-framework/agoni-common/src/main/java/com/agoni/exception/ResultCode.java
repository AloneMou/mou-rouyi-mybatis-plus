package com.agoni.exception;

import com.agoni.exception.enums.GlobalErrorCodeConstants;
import com.agoni.exception.enums.ServiceErrorCodeRange;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 错误码对象
 * <p>
 * 全局错误码，占用 [0, 999], 参见 {@link GlobalErrorCodeConstants}
 * 业务异常错误码，占用 [1 000 000 000, +∞)，参见 {@link ServiceErrorCodeRange}
 * @author AgoniMou
 * <p>
 * TODO 错误码设计成对象的原因，为未来的 i18 国际化做准备
 */
@Data
@AllArgsConstructor
public class ResultCode {

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 错误提示
     */
    private final String msg;
}
