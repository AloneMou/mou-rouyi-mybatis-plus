package com.agoni.core.constants;

import cn.hutool.core.lang.RegexPool;

/**
 * 常用正则表达式字符串池
 */
public class RegexConstant implements RegexPool {

    /**
     * 整数例如：-10，10，0
     *
     * @link <a href="https://any86.github.io/any-rule/">https://any86.github.io/any-rule/</a>
     */
    public static final String NUMBER_REGEX = "^(?:0|(?:-?[1-9]\\d*))$";

    /**
     * 正整数，不包含0
     */
    public static final String POSITIVE_NUMBER_REGEX = "^\\+?[1-9]\\d*$";

    /**
     * 负整数，不包含0
     */
    public static final String NEGATIVE_NUMBER_REGEX = "^-[1-9]\\d*$";

    /**
     * 密码强度校验，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
     */
    public static final String CRYPTOGRAPHIC_STRENGTH_ONE_REGEX = "^\\S*(?=\\S{6,})(?=\\S*\\d)(?=\\S*[A-Z])(?=\\S*[a-z])(?=\\S*[!@#$%^&*? ])\\S*$";

    /**
     * 大写字母，小写字母，数字，特殊符号 `@#$%^&*`~()-+=` 中任意3项密码
     */
    public static final String CRYPTOGRAPHIC_STRENGTH_TWO_REGEX = "^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\\W_!@#$%^&*`~()-+=]+$)(?![a-z0-9]+$)(?![a-z\\W_!@#$%^&*`~()-+=]+$)(?![0-9\\W_!@#$%^&*`~()-+=]+$)[a-zA-Z0-9\\W_!@#$%^&*`~()-+=]";

    //    public static final String
}
