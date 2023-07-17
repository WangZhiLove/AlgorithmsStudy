package com.algorithms.wz.skills.pointer;

/**
 * <a href="https://leetcode-cn.com/problems/max-consecutive-ones/">485. 最大连续 1 的个数</a>
 * <p>
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 * </p>
 *
 * @author wangzhi
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }

    /**
     * 快慢指针搞定，每次都要记录快慢指针的长度
     *
     * @param nums 数组
     * @return 连续 1 的最大长度
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int slow = 0;
        int fast = 0;
        int maxLen = 0;
        while (fast < nums.length) {
            if (nums[fast] == 1) {
                slow = fast;
                while (fast < nums.length && nums[fast] == 1) {
                    fast ++;
                }
                maxLen = Math.max(fast - slow, maxLen);
            } else {
                while (fast < nums.length && nums[fast] == 0) {
                    fast++;
                }
            }
        }
        return maxLen;
    }
}
