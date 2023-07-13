package com.algorithms.wz.skills.pointer;

/**
 * <a href="https://leetcode-cn.com/problems/reverse-string/">344. 反转字符串</a>
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o', 'a' };
        reverseString(chars);
        for (char aChar : chars) {
            System.out.println(aChar);
        }
    }

    /**
     * 反转字符串，暴力破解的花直接用另外一个数组，反向遍历就好，但是题目要求 O(1) 的空间，这就需要原地修改输入的数组了，典型的双指针，前后交换
     * @param s 字符串数组
     */
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left ++] = s[right];
            s[right --] = temp;
        }
    }
}
