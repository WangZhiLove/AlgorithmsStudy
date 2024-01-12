package com.algorithms.wz.skills.greedy;

/**
 * <a href="https://leetcode.cn/problems/jump-game/description/">55. 跳跃游戏</a>
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class JumpGame {

    /**
     * 这道题目让我直接想到了回溯，那就先用回溯试试看，回溯法不太行，解决不了 0 的情况
     *
     * @param nums 数组
     * @return 是否可以跳跃到最后一个索引
     */
    public boolean canJump(int[] nums) {
        return backtracking(nums, 0);
    }

    private boolean backtracking(int[] nums, int start) {
        if (start == nums.length - 1) {
            return true;
        }
        if (start > nums.length) {
            return false;
        }
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                return false;
            }
            for (int j = 1; j <= num; j++) {
                return backtracking(nums, i + j);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump2(new int[] {2, 3, 1, 1, 4}));
        System.out.println(jumpGame.canJump2(new int[] {3, 2, 1, 0, 4}));
        System.out.println(jumpGame.canJump2(new int[] {0, 2, 3}));
        System.out.println(jumpGame.canJump2(new int[] {0}));
    }

    /**
     * 其实换个思路，维护一个最远距离，用最远距离对比就可以
     * @param nums 数组
     * @return 是否可以跳跃到最后一个索引
     */
    public boolean canJump2(int[] nums) {
        int distance = 0;
        for (int i = 0; i < nums.length; i++) {
            if (distance >= nums.length - 1) {
                return true;
            }
            if (distance + nums[i] <= i) {
                return false;
            }
            distance = Math.max( nums[i] + i, distance);
        }
        return false;
    }
}
