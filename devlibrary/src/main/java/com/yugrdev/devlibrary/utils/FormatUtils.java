package com.yugrdev.devlibrary.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 项目名称：DevPKG
 * 类：FormatUtils
 * 描述：
 * 创建人：Yugr
 * 创建日期：2016/11/24
 * 时间：11:19
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class FormatUtils {

    /**
     * 使用正则规则解析字符串是否匹配
     *
     * @param rule   正则规则
     * @param string 字符串
     * @return true符合规则 false不符合规则
     */
    public static boolean check(String rule, String string) {
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    /**
     * 检验Email
     */
    public static boolean checkEmail(String email) {
        String rule = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        return check(rule, email);
    }

    /**
     * 检查国内电话
     */
    public static boolean checkPhone(String phone) {
        String rule = "[\\d{3}-\\d{8}|\\d{4}-\\{7,8}";
        return check(rule, phone);
    }

    /**
     * 检查身份证号码
     */
    public static boolean checkIDCard(String phone) {
        String rule = "^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$";
        return check(rule, phone);
    }
}
