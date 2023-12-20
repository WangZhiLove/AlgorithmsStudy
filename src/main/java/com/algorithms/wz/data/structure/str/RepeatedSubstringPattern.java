package com.algorithms.wz.data.structure.str;

/**
 * <a href="https://leetcode.cn/problems/repeated-substring-pattern/description/">459.重复的子字符串</a>
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 */
public class RepeatedSubstringPattern {

    /**
     * 枚举，只需要枚举一半就可以
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            // 如果子字符串的长度为 i，则 s 的长度除以 i 一定为 0
            if (s.length() % i == 0) {
                boolean match = true;
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 枚举，只需要枚举一半就可以
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPatter2(String s) {

        return false;
    }

}
