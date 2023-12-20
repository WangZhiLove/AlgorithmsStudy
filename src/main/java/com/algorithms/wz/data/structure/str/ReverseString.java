package com.algorithms.wz.data.structure.str;

/**
 * <a href="https://leetcode.cn/problems/reverse-string/description/">344.反转字符串</a>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class ReverseString {

    /**
     * O(1) 的空间复杂度，那就是原地修改，双指针进行交换吧
     *
     * @param s 字符串
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
        }
    }

}