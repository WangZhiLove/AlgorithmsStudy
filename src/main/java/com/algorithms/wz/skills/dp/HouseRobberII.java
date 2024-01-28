package com.algorithms.wz.skills.dp;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/house-robber-ii/description/">213.打家劫舍II</a>
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 */
public class HouseRobberII {

    /**
     * 这道题目就是把环转换成线性数组，分为两种情况，一种是取首元素，一种是取尾元素，然后比较二者的最大值就可以
     *
     * @param nums 房屋金额数组
     * @return 今晚能够偷窃到的最高金额
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robOne(Arrays.copyOfRange(nums, 0, nums.length - 1)),
            robOne(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    /**
     * 打家劫舍一的代码
     *
     * @param nums 房屋金额数组
     * @return 最高金额
     */
    public int robOne(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 声明 dp 数组，索引表示前 n 个房间，值表示前 n 个房间可以取到的最高金额
        int[] dp = new int[nums.length];
        // 递推公式：dp[j] = Math.max(dp[j - 1], dp[j - 2] + nums[i])
        // 初始化 dp 数组
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // 遍历，先遍历物品，后遍历背包
        for (int j = 2; j < dp.length; j++) {
            dp[j] = Math.max(dp[j - 1], dp[j - 2] + nums[j]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();
        System.out.println(houseRobberII.rob(new int[] {2, 3, 2}));
    }
}
