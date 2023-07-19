package com.algorithms.wz.data.structure.str;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/">557. 反转字符串中的单词 III</a>
 * <p>
 *  给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * </p>
 * @author wangzhi
 */
public class ReverseWordsInAStringIII {

    public static void main(String[] args) {
        String s = reverseWords2("Let's take LeetCode contest");
        System.out.println(s);
    }

    /**
     * 这个就是分割反转，试试看
     * @param s 字符串
     * @return 反转后的字符串
     */
    public static String reverseWords(String s) {
        String[] sArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sArr.length; i++) {
            String str = sArr[i];
            char[] charArray = str.toCharArray();
            for (int j = charArray.length - 1; j >= 0; j--) {
                sb.append(charArray[j]);
            }
            if (i != sArr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     *  原地算法，不需要额外的空间，时间复杂度是 O(n)
     * @param s 字符串
     * @return 反转后的字符串
     */
    public static String reverseWords2(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                continue;
            }
            // 反转字符串
            int left = i;
            while(i < charArray.length && charArray[i] != ' ') {
                i ++;
            }
            int right = i - 1;
            while (left <= right) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left ++;
                right --;
            }
        }
        return new String(charArray);
    }
}
