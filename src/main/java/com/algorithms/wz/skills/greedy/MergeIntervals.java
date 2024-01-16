package com.algorithms.wz.skills.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/merge-intervals/description/">56. 合并区间</a>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class MergeIntervals {

    /**
     * 先排序，再合并，相对来说简单一点
     *
     * @param intervals 原数组
     * @return 合并后的数组
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> resultList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] arr = new int[2];
            // 保存当前合并的最小值
            arr[0] = intervals[i][0];
            // curMax 表示当前合并的最大值
            int curMax = intervals[i][1];
            // 进行合并的操作
            while (i < intervals.length - 1 && curMax >= intervals[i + 1][0]) {
                i++;
                curMax = Math.max(curMax, intervals[i][1]);
            }
            arr[1] = curMax;
            resultList.add(arr);
        }
        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(mergeIntervals.merge(new int[][] {{2, 6}, {1, 3}, {15, 18}, {8, 10}}));
    }
}
