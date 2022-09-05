package com.agoni.pojo;

import com.agoni.exception.enums.GlobalErrorCodeConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * 通用响应
 *
 * @param <T>
 * @author AgoniMou
 */
@Data
@ApiModel("通用响应")
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 响应时间戳
     */
    @ApiModelProperty("响应时间戳")
    private Long timestamp;


    /**
     * 响应码
     */
    @ApiModelProperty("响应码")
    private Integer code;

    /**
     * 响应数据
     */
    @ApiModelProperty("响应数据")
    private T data;

    /**
     * 错误提示
     */
    @ApiModelProperty("错误提示，用户可阅读")
    private String msg;

    public static <T> CommonResult<T> error(Integer code, String message) {
        Assert.isTrue(!GlobalErrorCodeConstants.SUCCESS.getCode().equals(code), "code 必须是错误的！");
        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.msg = message;
        return result;
    }
}
