package com.algorithms.wz.skills.greedy;

/**
 * <a href="https://leetcode.cn/problems/monotone-increasing-digits/description/">738.单调递增的数字</a>
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * <p>
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 */
public class MonotoneIncreasingDigits {

    /**
     * 先找到前缀为递增的索引，然后往回减一遍历，知道前面一位小于后面一位减一，之后将后面全部置为 9
     *
     * @param n 数字
     * @return 返回 小于或等于 n 的最大数字，且数字呈 单调递增
     */
    public int monotoneIncreasingDigits(int n) {
        if (n < 10) {
            return n;
        }
        String str = String.valueOf(n);
        char[] charArray = str.toCharArray();
        // 先求出最大数的索引，也就是递增的额索引
        int maxNumIndex = 1;
        while (maxNumIndex < charArray.length && charArray[maxNumIndex - 1] <= charArray[maxNumIndex]) {
            maxNumIndex ++;
        }
        if (maxNumIndex < charArray.length) {
            while (maxNumIndex > 0 && charArray[maxNumIndex - 1] > charArray[maxNumIndex]) {
                charArray[maxNumIndex - 1] -= 1;
                maxNumIndex --;
            }
            for (int i = maxNumIndex + 1; i < charArray.length; i++) {
                charArray[i] = '9';
            }
        }
        return Integer.parseInt(new String(charArray));
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits monotoneIncreasingDigits = new MonotoneIncreasingDigits();
        System.out.println(monotoneIncreasingDigits.monotoneIncreasingDigits(332));
    }
}
