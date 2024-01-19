package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/fibonacci-number/description/">509. 斐波那契数</a>
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 */
public class FibonacciNumber {

    /**
     * 既然学到动态规划，那就用动态规划的方式来解决
     *
     * @param n 数字 n
     * @return 斐波那契数列的 F(n)
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        // 首先可以确定使用一维数组，那数组的长度多少呢，就是 n + 1，下标代表着第 n 个数，值代表的第 n 个数对应的斐波那契数的值
        int[] arr = new int[n + 1];
        // 递推公式是什么呢？ arr[n] = arr[n - 1] + arr[n - 2]
        // 然后进行初始化
        arr[0] = 0;
        arr[1] = 1;
        // 遍历
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 简化可以不使用数组
     *
     * @param n 数字 n
     * @return 斐波那契数列的 F(n)
     */
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int i = 2;
        while (i <= n) {
            int temp = b;
            b = a + b;
            a = temp;
            i ++;
        }
        return b;
    }
}
