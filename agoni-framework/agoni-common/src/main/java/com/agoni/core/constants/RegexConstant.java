package com.agoni.core.constants;

import cn.hutool.core.lang.RegexPool;

/**
 * 常用正则表达式字符串池
 *
 * @author AgoniMou
 * @since 2022-09-16
 */
public interface RegexConstant extends RegexPool {

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

    /**
     * 身份证校验 15/18位身份证号码验证
     */
    public static final String CARD_NO = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$";

}
