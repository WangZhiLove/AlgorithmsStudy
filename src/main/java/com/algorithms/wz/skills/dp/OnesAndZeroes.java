package com.algorithms.wz.skills.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/ones-and-zeroes/description/">474.一和零</a>
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 */
public class OnesAndZeroes {

    /**
     * 0-1背包，这道题目我的思想是使用二维数组来解决，要求 dp[m][n]，和物品的 0 和 1 的个数有关系，dp[m][n] = Math.max(dp[m][n], dp[m - strs[i0]][n - strs[i1]] + 1)
     *
     * @param strs 01字符串数组
     * @param m    0 的个数
     * @param n    1 的个数
     * @return 最大的子集长度
     */
    public int findMaxForm(String[] strs, int m, int n) {
        Map<Integer, int[]> map = new HashMap<>();
        // 遍历 strs，找出每一个元素中 0 和 1 的个数
        for (int i = 0; i < strs.length; i++) {
            int[] arr = new int[2];
            for (int j = 0; j < strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                if (c == '0') {
                    arr[0]++;
                } else if (c == '1') {
                    arr[1]++;
                }
            }
            map.put(i, arr);
        }
        // 声明 dp 数组，索引 i 表示 0 的个数，索引 j 表示 1 的个数，值表示最大子集的长度
        int[][] dp = new int[m + 1][n + 1];
        // 找到递推公式：dp[i][j] = Math.max(dp[i][j], dp[i - strs[k]0的个数][j- strs[k]1的个数] + 1)
        // 初始化，全部初始化为 0 即可
        // 遍历，为了避免重复使用，背包需要倒序遍历
        for (int k = 0; k < strs.length; k++) {
            int[] ints = map.get(k);
            for (int i = dp.length - 1; i >= ints[0]; i--) {
                for (int j = dp[i].length - 1; j >= ints[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - ints[0]][j - ints[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        OnesAndZeroes onesAndZeroes = new OnesAndZeroes();
        System.out.println(onesAndZeroes.findMaxForm(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
