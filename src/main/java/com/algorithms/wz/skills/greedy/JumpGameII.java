package com.algorithms.wz.skills.greedy;

/**
 * <a href="https://leetcode.cn/problems/jump-game-ii/description/">45.跳跃游戏II </a>
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */
public class JumpGameII {

    /**
     * 和跳跃游戏相似，我可以维护一个跳跃的数组，也就是如果跳跃到某一个索引，那应该跳几次
     *
     * @param nums 数组
     * @return 跳跃的最少次数
     */
    public int jump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        // 维护跳跃次数的数组
        int[] jumpNums = new int[nums.length];
        // 维护当前可跳跃的最远距离
        int maxLength = nums[0];
        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, nums[i] + i);
            // 维护跳跃次数数组
            for (int length = maxLength; length > 0; length--) {
                if (length >= jumpNums.length) {
                    length = jumpNums.length - 1;
                }
                if (jumpNums[length] != 0) {
                    break;
                }
                jumpNums[length] = jumpNums[i] + 1;
            }
            // 如果已经大于最远距离，直接返回
            if (maxLength >= nums.length - 1) {
                return jumpNums[i] + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        System.out.println(jumpGameII.jump(new int[] {2, 1, 1, 1, 1}));
    }

}
