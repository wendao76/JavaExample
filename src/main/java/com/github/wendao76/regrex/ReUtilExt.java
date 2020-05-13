package com.github.wendao76.regrex;


import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具
 *
 * @author lwh
 * @version 1.0
 * @description 正则表达式工具
 * @date 2020-5-12 16:08
 */
@Slf4j
public class ReUtilExt {
    private static final Integer PHONE_NUMBER_LENGTH = 11;

    /**
     * 电话号码校验
     *
     * @param phone 电话号码
     * @return 是否符合电话号码
     * @update smile7up
     * @update Zhangxurui
     */
    public static boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$";
        if (phone.length() != PHONE_NUMBER_LENGTH) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            return m.matches();
        }
    }

    /**
     * 自定义渲染模板
     *
     * @param template 模版
     * @param params   参数
     * @return
     */
    public static String processTemplate(String template, Map<String, Object> params) {
        if (template == null || params == null)
            return null;
        StringBuffer sb = new StringBuffer();
        Matcher m = Pattern.compile("\\$\\{\\w+\\}").matcher(template);
        while (m.find()) {
            String param = m.group();
            Object value = params.get(param.substring(2, param.length() - 1));
            m.appendReplacement(sb, value == null ? "" : value.toString());
        }
        m.appendTail(sb);
        return sb.toString();
    }

    /**
     * 自定义渲染模板
     *
     * @param template 模版
     * @param params   参数
     * @return
     */
    public static <T> String processTemplate(String template, List<T> params) {
        if (template == null || params == null)
            return null;
        StringBuffer sb = new StringBuffer();
        Matcher m = Pattern.compile("\\$\\{\\w+\\}").matcher(template);
        int idx = 0;
        while (m.find()) {
            Object value = params.get(idx++);
            m.appendReplacement(sb, value == null ? "" : value.toString());
        }
        m.appendTail(sb);
        return sb.toString();
    }
}
