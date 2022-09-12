package com.agoni.validation.annotation;


import com.agoni.validation.impl.EnumsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义注解
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EnumsValidator.class)
public @interface EnumsValue {

    /**
     * 通过枚举类校验
     */
    Class<? extends Enum>[] enums() default {};

    /**
     * 校验不通过提示
     */
    String message() default "";

    /**
     * 分组
     */
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
