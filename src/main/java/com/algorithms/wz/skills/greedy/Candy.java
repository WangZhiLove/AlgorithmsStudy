package com.algorithms.wz.skills.greedy;

/**
 * <a href="https://leetcode.cn/problems/candy/description/">135. 分发糖果</a>
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 */
public class Candy {

    /**
     * 没太看懂题目要求，看例子那就是孩子要么得到一个，要么得到两个，那我判断每一个孩子的时候都需要和前一个孩子以及后一个孩子对比，如果存在大的，就是 2，否则就是 1
     * 知道了，这道题目有一个条件就是如果前一个孩子得到的是 2 个糖果，那下一个孩子如果高于前一个孩子，得到的应该是 3，而不是 2，那这个就需要保存前一个孩子得到的糖果数了
     *
     * @param ratings 评分
     * @return 最少的糖果数目
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[ratings.length];
        // 先左遍历一遍
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        // 再右遍历一遍，这个思路挺好
        int result = 0;
        int right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right ++;
            } else {
                right = 1;
            }
            result += Math.max(left[i], right);
        }
        return result;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        System.out.println(candy.candy(new int[] {1,2,87,87,87,2,1}));
    }

}
