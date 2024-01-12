package com.algorithms.wz.skills.greedy;

/**
 * <a href="https://leetcode.cn/problems/wiggle-subsequence/description/">376. 摆动序列</a>
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 * <p>
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 * <p>
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 * <p>
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 */
public class WiggleSubsequence {

    /**
     * 想象一连串山峰山谷，遇到山峰和山谷就加一
     *
     * @param nums 数组
     * @return 最大的摆动序列长度
     */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int result = 1;
        boolean flag = true;
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                while (i < n && nums[i] == nums[i - 1]) {
                    i ++;
                }
                if (i == n) {
                    return 1;
                }
                flag = nums[i] - nums[i -1] > 0;
                result ++;
            } else {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
                boolean temp = nums[i] - nums[i -1] > 0;
                if (flag != temp) {
                    result ++;
                    flag = temp;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        WiggleSubsequence wiggleSubsequence = new WiggleSubsequence();
        int i = wiggleSubsequence.wiggleMaxLength(new int[] {1, 17, 5, 10, 13, 15, 10, 5, 16, 8});
        System.out.println(i);
    }
}
