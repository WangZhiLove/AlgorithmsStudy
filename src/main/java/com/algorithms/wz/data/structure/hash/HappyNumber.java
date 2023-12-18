package com.algorithms.wz.data.structure.hash;

/**
 * <a href="https://leetcode.cn/problems/happy-number/description/">202. 快乐数</a>
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 */
public class HappyNumber {

    /**
     * 脑海中的第一个想法就是取 n 的每一位，然后平方相加，直到结果为 1，但是会出现无线循环，这如何破解呢？所以这道题目应该不是按照流程做，而是找规律。
     * <p>
     * 没有想出来，看了题解之后有点明白，其实这道题目有三种结果：一个是到 1；一个是出现循环；一个是无限变大，现在想想第三种情况是否可以出现，使用归纳法，
     * 每一位的最大数字的下一位：9->81;99->162;999->243;9999->324;9999999999999->1053; 也就是说第三种情况是不可能出现的，所有的大数字最后都会
     * 归于三位，也就是不会超过 324,一直在 324 下循环，所以现在就是两种情况，一个是到 1，一个是在 324 下循环，我们递归，直到出现 1 或者重复出现 324
     * 内的一个数字，结束递归。
     *
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        int[] arr = new int[325];
        return myIsHappy(n, arr);
    }

    public static boolean myIsHappy(int n, int[] arr) {
        if (n == 1) {
            return true;
        }
        if (n < 325 && arr[n] == 2) {
            return false;
        }
        int sum = getNext(n);
        if (sum < 325) {
            arr[sum]++;
        }
        return myIsHappy(sum, arr);
    }

    public static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n /= 10;
            sum += d * d;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(1999999999));
        System.out.println(isHappy(19));
        System.out.println(isHappy(99));
    }

    // 既然能形成环，那就试试链表环的思路吧
    public static boolean isHappy2(int n) {
        // arr 加一层缓存，防止计算 next 的时候重复计算
        int[] arr = new int[1000];
        int slow = n;
        int fast = getNext2(n, arr);
        while (fast != 1 && fast != slow) {
            slow = getNext2(slow, arr);
            fast = getNext2(getNext2(fast, arr), arr);
        }
        return fast == 1;
    }

    private static int getNext2(int n, int[] arr) {
        if (n < 1000 && arr[n] != 0) {
            return arr[n];
        }
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n /= 10;
            sum += d * d;
        }
        if (n < 1000) {
            arr[n] = sum;
        }
        return sum;
    }
}
