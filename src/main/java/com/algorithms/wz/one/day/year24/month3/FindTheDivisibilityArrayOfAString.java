package com.algorithms.wz.one.day.year24.month3;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-the-divisibility-array-of-a-string/description/">2575. 找出字符串的可整除数组</a>
 * 给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
 * <p>
 * word 的 可整除数组 div  是一个长度为 n 的整数数组，并满足：
 * <p>
 * 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
 * 否则，div[i] = 0
 * 返回 word 的可整除数组。
 */
public class FindTheDivisibilityArrayOfAString {

    /**
     * 直接暴力破解试试看，看来暴力破解的方法行不通，那就得找规律了，如何找呢？我想这道题目应该是动态规划的题目
     * @param word 数字字符串
     * @param m 正整数 m
     * @return word 的可整除数组
     */
    public int[] divisibilityArray(String word, int m) {
        int[] result = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            String substring = word.substring(0, i + 1);
            long value = Long.parseLong(substring);
            result[i] = value % m == 0 ? 1 : 0;
        }
        return result;
    }

    public static void main(String[] args) {
        FindTheDivisibilityArrayOfAString findTheDivisibilityArrayOfAString = new FindTheDivisibilityArrayOfAString();
        int[] ints = findTheDivisibilityArrayOfAString.divisibilityArray1("998244353", 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    /**
     * 纯碎想多了，这是一道数学题，根据上一位的余数来计算本位是否整除
     */
    public int[] divisibilityArray1(String word, int m) {
        int[] result = new int[word.length()];
        long remainder = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            remainder = (remainder * 10 + (c - '0')) % m;
            result[i] = remainder == 0 ? 1 : 0;
        }
        return result;
    }

}
