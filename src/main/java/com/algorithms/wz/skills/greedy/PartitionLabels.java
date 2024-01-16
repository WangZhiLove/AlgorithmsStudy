package com.algorithms.wz.skills.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/partition-labels/description/">763.划分字母区间</a>
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * <p>
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * <p>
 * 返回一个表示每个字符串片段的长度的列表。
 */
public class PartitionLabels {

    /**
     * 这道题目我的思路是什么呢？就是计算开头字母的最后一次出现的索引，然后判断这区间的任何一个字母出现的最后一个索引，取出最大的索引就好。
     * 算法没错，可以借用缓存
     *
     * @param s 原字符串
     * @return 分割后每个子字符串的长度
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int lastIndex = s.lastIndexOf(c);
            if (lastIndex == s.length() - 1) {
                result.add(lastIndex - i + 1);
                break;
            } else if (i == lastIndex) {
                result.add(1);
            } else {
                int temp = i + 1;
                while (temp < lastIndex && lastIndex != s.length() - 1) {
                    lastIndex = Math.max(lastIndex, s.lastIndexOf(s.charAt(temp)));
                    temp++;
                }
                result.add(lastIndex - i + 1);
                i = lastIndex;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels("eccbbbbdec"));
    }

    /**
     * 借用一个数组，先找出原数组中，每一个字符出现的最后一个索引
     *
     * @param s 元字符串
     * @return 分割后每个子字符串的长度
     */
    public List<Integer> partitionLabels2(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (end == i) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
