package com.algorithms.wz.one.day.year24.month3;


/**
 * <a href="https://leetcode.cn/problems/capitalize-the-title/">2129. 将标题首字母大写</a>
 * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
 * <p>
 * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
 * 否则，将单词首字母大写，剩余字母变成小写。
 * 请你返回 大写后 的 title 。
 *
 */
public class CapitalizeTheTitle {

    /**
     * 这道题目就是个字符串转化，首先是判断字符串的长度是否大于2，如果是，则首字母大些，其余小写，如果不是，则全部小写
     * @param title 标题
     * @return 转化后的标题
     */
    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        // 将文本分割为字符串数组，先全部转小写
        title = title.toLowerCase();
        String[] strArr = title.split(" ");
        // 遍历每一个数组，进行字符串转化
        for (int i = 0; i < strArr.length; i++) {
            sb.append(capitalizeStr(strArr[i]));
            if (i != strArr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 如果字符串的长度小于等于2，返回全小写的字符串，如果字符串的长度大于2，返回首字母大写的字符串
     * @param str 字符串
     * @return 转化后的字符串
     */
    private String capitalizeStr(String str) {
        if (str.length() <= 2) {
            return str.toLowerCase();
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
