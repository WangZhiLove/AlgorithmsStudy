package com.algorithms.wz.data.structure.str;

/**
 * <a href="https://leetcode.cn/problems/longest-common-prefix/">14. 最长公共前缀</a>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author wangzhi
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

    }

    /**
     * 这道题刚拿上，我就想到了暴力破解，就是双层 for 循环，果然暴力破解的方法是可以的，并且执行用时特别短。
     *
     * 有没有其它的解决方案呢？
     *
     * @param strs 字符串数组
     * @return 最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        // 特殊情况排除
        if (strs.length == 1) {
            return strs[0];
        }
        // 其余情况判断
        StringBuilder sb = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(str.length(), minLen);
        }
        // 如果包含字符串长度为 0 的，则表示没有公共前缀
        if (minLen == 0) {
            return sb.toString();
        }
        for (int i = 0; i < minLen; i++) {
            // 获取字符，用于后续的判断
            char ch = strs[0].charAt(i);
            // 标识位，用于判断是否相同
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (ch != strs[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
