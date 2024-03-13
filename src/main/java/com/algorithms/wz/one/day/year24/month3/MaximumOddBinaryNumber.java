package com.algorithms.wz.one.day.year24.month3;

/**
 * <a href="https://leetcode.cn/problems/maximum-odd-binary-number/description/">2864. 最大的二进制奇数</a>
 * 给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。
 * <p>
 * 你必须按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。
 * <p>
 * 以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。
 * <p>
 * 注意 返回的结果字符串 可以 含前导零。
 */
public class MaximumOddBinaryNumber {

    /**
     * 最大的二进制奇数，我是如何思考的呢？就是统计 1 的个数，然后其中一个1放在末尾，随后所有的 1 放在前面
     * @param s 原字符串
     * @return 最大的二进制奇数
     */
    public String maximumOddBinaryNumber(String s) {
        int length = s.length();
        int oneNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                oneNum ++;
            }
        }
        // 构造新的字符串
        StringBuilder sb = new StringBuilder();
        while (sb.length() < oneNum - 1) {
            sb.append("1");
        }
        while (sb.length() < length - 1) {
            sb.append(0);
        }
        return sb.append("1").toString();
    }

    public String maximumOddBinaryNumber1(String s) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s0 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                s1.append('1');
            } else {
                s0.append('0');
            }
        }
        return s1.substring(1) + s0.append('1');
    }

    public static void main(String[] args) {
        MaximumOddBinaryNumber maximumOddBinaryNumber = new MaximumOddBinaryNumber();
        System.out.println(maximumOddBinaryNumber.maximumOddBinaryNumber("010"));
    }

}
