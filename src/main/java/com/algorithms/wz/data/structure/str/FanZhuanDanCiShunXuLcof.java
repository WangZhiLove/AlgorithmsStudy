package com.algorithms.wz.data.structure.str;

/**
 * <a href="https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/">剑指 Offer 58 - I. 翻转单词顺序</a>
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 同 <a href="https://leetcode.cn/problems/reverse-words-in-a-string/">151. 反转字符串中的单词</a>
 * @author wangzhi
 */
public class FanZhuanDanCiShunXuLcof {

    public static void main(String[] args) {
        String s = reverseWords2("  hello world  ");
        System.out.println(s);
    }

    /**
     * 最直观的解法，字符串分割，然后拼接
     * @param s 字符串
     * @return 反转后的字符串
     */
    public static String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            if ("".equals(strArr[i])) {
                continue;
            }
            if (i != strArr.length - 1) {
                sb.append(" ");
            }
            sb.append(strArr[i].trim());
        }
        return sb.toString();
    }

    /**
     *  如何使用 O（1）的空间复杂度呢？
     * @param s 字符串
     * @return 反转后的字符串
     */
    public static String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int lastIndex;
        for (int i = s.length() - 1; i >= 0;) {
            lastIndex = i;
            // 双指针，获取区间
            while(i >= 0 && s.charAt(i) != ' ') {
                i --;
            }
            // 截取
            sb.append(s.substring(i + 1, lastIndex + 1).trim()).append(" ");
            // 防止出现连续的空格，也可以改写成 if，把 append 放在 if 里面
            while (i >= 0 && s.charAt(i) == ' ') {
                i --;
            }
        }
        // 去掉多余的空格
        return sb.toString().trim();
    }
}
