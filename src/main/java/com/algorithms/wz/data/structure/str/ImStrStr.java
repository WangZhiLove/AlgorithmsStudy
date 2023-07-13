package com.algorithms.wz.data.structure.str;

/**
 * <a href="https://leetcode-cn.com/problems/implement-strstr/">28. 实现 strStr()</a>
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * @author wangzhi
 */
public class ImStrStr {

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("hello", "ll"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int leftIndex = -1;
        for (int i = needle.length() - 1; i < haystack.length(); i++) {
            int needleIndex = needle.length() - 1;
            int j = i;
            while (needleIndex >= 0 && needle.charAt(needleIndex) == haystack.charAt(j)) {
                needleIndex --;
                j --;
            }
            if (needleIndex == -1) {
                // 或者等于 i - needleIndex
                leftIndex = j + 1;
                break;
            }
        }
        return leftIndex;
    }
}
