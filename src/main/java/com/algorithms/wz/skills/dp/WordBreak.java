package com.algorithms.wz.skills.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/word-break/description/">139.单词拆分</a>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class WordBreak {

    /**
     * 重复使用，那就是完全背包问题了，那这道背包题目如何解决呢？首先物品是确定的，wordDict，背包就不是很明确了，如何把 s 转成背包就是这个
     * 问题的关键了
     *
     * 先不用递归，按照我自己的思路来实现看看，果然解决不了某些问题，还是看题解吧
     *
     * @param s        目标字符串
     * @param wordDict 字符串列表
     * @return 字符串列表是否可以拼接成目标字符串
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 首先取出字典中有用的字符串
        List<String> myWordDict = new ArrayList<>();
        for (String string : wordDict) {
            if (s.contains(string)) {
                myWordDict.add(string);
            }
        }
        if (myWordDict.isEmpty() && !s.isBlank()) {
            return false;
        }
        // 进行遍历
        int index = 0;
        while (index < s.length()) {
            int temp = index;
            for (String string : myWordDict) {
                if (s.indexOf(string, index) == index) {
                    index += string.length();
                    break;
                }
            }
            if (index == temp) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak2("aaaaaaa", List.of("aaaa","aaa")));
        System.out.println(wordBreak.wordBreak2("leetcode", List.of("leet", "code")));
        System.out.println(wordBreak.wordBreak2("applepenapple", List.of("apple", "pen")));
        System.out.println(wordBreak.wordBreak2("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }

    /**
     * 递归的话和我的思路有点像，来试试看
     * @param s        目标字符串
     * @param wordDict 字符串列表
     * @return 字符串列表是否可以拼接成目标字符串
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        // 声明 dp 数组，dp 数组的索引表示字符串的长度，值表示是否可以由 wordDict 组成
        boolean[] dp = new boolean[s.length() + 1];
        // 递推公式是什么呢？这个非常规的递推公式，其实就是判断 dp[j] = [j - i] 是再 s 内，并且 dp[j - i] 为 true
        // 初始化
        dp[0] = true;
        // 遍历
        for (int i = 0; i < dp.length; i++) {
            for (String str : wordDict) {
                if (s.indexOf(str, i) == i && !dp[i + str.length()]) {
                    dp[i + str.length()] = dp[i];
                }
            }
        }
        return dp[s.length()];
    }

}
