package com.agoni.validation.impl;

import com.agoni.validation.annotation.EnumsValue;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义验证器
 */
public class EnumsValidator implements ConstraintValidator<EnumsValue, String> {

    /**
     * 接收注解传过来的值
     */
    private final Set<String> enumName = new HashSet<>();

    /**
     * 初始化方法，可以获取注解的参数信息
     */
    @Override
    public void initialize(EnumsValue matchValue) {
        try {
            Class<? extends Enum>[] enums = matchValue.enums();
            if (enums.length > 0) {
                Enum[] enumConstants = Arrays.stream(enums).findFirst().get().getEnumConstants();
                for (Enum e : enumConstants) {
                    enumName.add(e.name());
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


    /**
     * 校验值
     *
     * @param value   参数的值信息
     * @param context 上下文对象，可以禁用默认提示模板，然后更改提示模板
     * @return boolean
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!StringUtils.isEmpty(value)) {
            for (String name : enumName) {
                if (name.equals(value)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
