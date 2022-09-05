package com.agoni.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 排序字段 DTO
 * <p>
 * 类名加了 ing 的原因是，避免和 ES SortField 重名。
 *
 * @author AgoniMou
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SortingField implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 字段
     */
    private String field;
    /**
     * 顺序
     */
    private String order;


}
