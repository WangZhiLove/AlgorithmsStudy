package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/last-stone-weight-ii/description/">1049.最后一块石头的重量II</a>
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 */
public class LastStoneWeightII {

    /**
     * 0-1 背包问题，如何把这道题目转化成我会做的问题呢？物品是确定的，stones，重量和价值相同，就是 stones[i]，背包自然就是我们的 dp 数组了
     * 其实和上一个分割等和子序列相似，如果可以完全分成两堆重量一样，那就返回 0，否则就是 Math.abs(sum-dp[sum/2]-dp[sum/2])
     * 否则等会 dp[sum/2] - (sum - 1)/2 + 1
     *
     * @param stones 石头
     * @return 粉碎后的最小重量
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int dpLength = sum / 2;
        // 声明 dp 数组，索引表示背包容纳的最大重量, 值就是最大的石头
        int[] dp = new int[dpLength + 1];
        // 递推公式：dp[j] = Math.max(dp[j], dp[j - stones[i] + stones[i]])
        // 初始化为 0
        // 遍历
        for (int i = 0; i < stones.length; i++) {
            for (int j = dp.length - 1; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return Math.abs(sum - dp[dpLength] - dp[dpLength]);
    }

}
