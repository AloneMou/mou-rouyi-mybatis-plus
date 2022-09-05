package com.agoni.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel("分页结果")
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 2L;

    @ApiModelProperty(value = "数据", required = true)
    private List<T> rows;

    @ApiModelProperty(value = "总量", required = true)
    private Long total;

    public PageResult() {
    }

    public PageResult(List<T> rows, Long total) {
        this.rows = rows;
        this.total = total;
    }

    public PageResult(Long total) {
        this.rows = new ArrayList<>();
        this.total = total;
    }

    public static <T> PageResult<T> empty() {
        return new PageResult<>(0L);
    }

    public static <T> PageResult<T> empty(Long total) {
        return new PageResult<>(total);
    }

}
