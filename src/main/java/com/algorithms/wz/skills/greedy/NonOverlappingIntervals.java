package com.algorithms.wz.skills.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/non-overlapping-intervals/description/">435. 无重叠区间</a>
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 */
public class NonOverlappingIntervals {

    /**
     *
     * @param intervals 原重叠区间
     * @return 移除区间的最小数量
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                ans++;
                right = intervals[i][1];
            }
        }
        return intervals.length - ans;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals2(new int[][] {{1, 3}, {2, 5}, {4, 8}}));
    }

    public int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int left = intervals[0][1];
        int result = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < left) {
                result ++;
                left = Math.min(left, intervals[i][1]);
            } else {
                left = intervals[1][1];
            }
        }
        return result;
    }
}
