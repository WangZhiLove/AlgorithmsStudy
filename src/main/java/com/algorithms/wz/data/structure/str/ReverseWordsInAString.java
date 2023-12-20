package com.algorithms.wz.data.structure.str;

import java.util.Scanner;

/**
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string/description/"> 151.翻转字符串里的单词 </a>
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (!strArr[i].isBlank()) {
                sb.append(strArr[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        System.out.println(reverseWordsInAString.reverseWords2(str));
        scanner.close();
    }

    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0;) {
            int index = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i --;
            }
            sb.append(s.substring(i + 1, index + 1).trim()).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i --;
            }
        }
        return sb.toString().trim();
    }
}
