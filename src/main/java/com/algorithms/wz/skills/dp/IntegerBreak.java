package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/integer-break/description/">343. 整数拆分</a>
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积 。
 */
public class IntegerBreak {

    /**
     * 题目理解错了，怎么都想不明白，这道题目理解错了，我以为是分为两个数，两个数又可以继续分，但是是错了，而是一个不变，一个继续分
     * @param n 正整数 n
     * @return 最大的乘积
     */
    public int integerBreak(int n) {
        // 声明 dp， dp[i] 表示 i 被拆分至少两个正整数后的最大乘积，i 表示的正整数
        int[] dp = new int[n + 1];
        // 找出递推公式，i 被拆分成 j 和 i - j，那最大值是多少呢？Math.max(j * dp[i - j]， j * (i - j))
        // 初始化，数字 0 和 1 是没办法拆分的，所以直接就是 0 了
        // 遍历，正向遍历，内部也需要遍历
        for (int i = 2; i < dp.length; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
               curMax = Math.max(curMax, Math.max(j * dp[i - j], j * (i - j)));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    /**
     * 这道题目我怎么感觉递归的思路更简单呢？我的思路就是二分法，因为一个数分成两个数，两个数想乘一定大于这个数，说的是正数的情况，0 和 1 除外
     * @param n 正整数 n
     * @return 最大乘积
     */
    public int integerBreak2(int n) {
        // 先求出 n 被分割一次，如何最大，那肯定是 n/2 的时候最大，就比如 10 ： 5 * 5 最大，4 * 6 就小
        int i = n / 2;
        int j = n - i;
        if (i <= 3 || j <= 3) {
            return i * j;
        } else {
            return integerBreak2(i) * integerBreak2(j);
        }
    }

    public static void main(String[] args) {
        IntegerBreak integerBreak = new IntegerBreak();
        System.out.println(integerBreak.integerBreak(6));
    }

}
