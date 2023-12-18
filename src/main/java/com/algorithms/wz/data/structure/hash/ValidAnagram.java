package com.algorithms.wz.data.structure.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/valid-anagram/description/"> 242.有效的字母异位词 </a>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */
public class ValidAnagram {

    /**
     * 直接使用哈希保存，遍历一个字符串计算每个单词出现的个数，遍历另外一个字符串进行减去个数，最后结果都是 0 就好
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        char[] sCharArray = s.toCharArray();
        for (char c : sCharArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char[] tCharArray = t.toCharArray();
        for (char c : tCharArray) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 考虑使用数组
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        int[] arr = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        char[] sCharArray = s.toCharArray();
        for (char c : sCharArray) {
            arr[c - 97] ++;
        }
        char[] tCharArray = t.toCharArray();
        for (char c : tCharArray) {
            arr[c - 97] --;
        }
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }



}
