package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/house-robber/description/">198.打家劫舍</a>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class HouseRobber {

    /**
     * 这道题目感觉用递归五部曲可以做出来，就是使用 dp 来推到就行
     *
     * @param nums 房屋金额
     * @return 最高金额
     */
    public int rob(int[] nums) {
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
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(new int[] {1, 2, 3, 1}));
        System.out.println(houseRobber.rob(new int[] {2, 7, 9, 3, 1}));
    }
}
