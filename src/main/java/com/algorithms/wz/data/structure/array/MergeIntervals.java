package com.algorithms.wz.data.structure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/merge-intervals/">56. 合并区间</a>
 * 给出一个区间的集合，请合并所有重叠的区间。
 * @author wangzhi
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] merge = merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0] + ":" + merge[i][1]);
        }
    }

    /**
     * 二维数组的题目，我的思路跑偏了，考虑太多的情况，其实先将二维数组排序，很多时候将数组排序一下会方便很多，然后再合并
     *
     * @param intervals 二维数组
     * @return 合并后的二维数组
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        // p排序
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int leftNum = intervals[0][0];
        int rightNum = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (rightNum >= interval[0]) {
                rightNum = Math.max(rightNum, interval[1]);
            } else {
                result.add(Arrays.asList(leftNum, rightNum));
                leftNum = interval[0];
                rightNum = interval[1];
            }
            // 结束，没有下一轮了
            if (i == intervals.length - 1) {
                result.add(Arrays.asList(leftNum, rightNum));
            }
        }
        // 转换数组
        int[][] resultArr = new int[result.size()][2];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i][0] = result.get(i).get(0);
            resultArr[i][1] = result.get(i).get(1);
        }
        return resultArr;
    }

    /**
     * 代码优化
     * 这倒题目让我学到了什么呢？一个是数组结构的使用，我发现我有的时候太死板了，不会灵活使用数据结构，其次思想有些固化，排序等 api 使用的不太好，这可不太好。
     * 还得多练习
     * @param intervals 二维数组
     * @return 合并后的数组
     */
    public static int[][] merge2(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        // 排序
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int[] interval : intervals) {
            int leftNum = interval[0], rightNum = interval[1];
            if (result.isEmpty() || result.get(result.size() - 1)[1] < leftNum) {
                result.add(new int[]{leftNum, rightNum});
            } else {
                result.get(result.size() - 1)[1] = Math.max(rightNum, result.get(result.size() - 1)[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
