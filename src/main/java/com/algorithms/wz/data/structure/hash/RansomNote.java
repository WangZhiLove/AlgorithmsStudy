package com.algorithms.wz.data.structure.hash;

/**
 * <a href="https://leetcode.cn/problems/ransom-note/description/">383. 赎金信 </a>
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class RansomNote {

    /**
     * 直接使用数组，因为只包含小写字母，先遍历 magazine，找到所有字符出现的次数，然后再看看能不能组成 ransomNote
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        char[] charArray = magazine.toCharArray();
        for (char c : charArray) {
            arr[c - 97] ++;
        }
        for (char c : ransomNote.toCharArray()) {
            arr[c - 97] --;
            if (arr[c - 97] == -1) {
                return false;
            }
        }
        return true;
    }
}
