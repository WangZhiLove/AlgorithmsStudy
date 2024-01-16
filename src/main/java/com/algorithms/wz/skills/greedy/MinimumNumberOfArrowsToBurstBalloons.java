package com.algorithms.wz.skills.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/description/">452. 用最少数量的箭引爆气球</a>
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * <p>
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    /**
     * 这道题目是否可以转换一下呢？就是合并，但是合并有要求，也就是 n 个 x 坐标必须同时有交点。比如 [1,2],[2,3],[3,4]，这个可以前两个合，可以后两个和，但是不允许三个合和
     * 如果按照这种思路，那我觉得可以计算出来，关键是看 points[1] 如何使用，这个方案本身存在问题，因为相交的点需要判断，所以需要额外声明一个数组来存放相交的点，这个就不值当了。
     * 看了题解之后题解也是排序，是按照 x 轴的最远距离排序，仔细一想，用最远距离排序是正确的，只有最远距离才可以包容，用最近距离排序，然后用最远距离包容就会出现问题，举个例子就是：
     * {1, 10}，{6, 7}，{8, 12} 用最近距离排序算下来就是需要一支箭，但这是错的
     *
     * @param points 气球的 x 坐标
     * @return 最小的弓箭数
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        // 排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int result = 0;
        // 双指针判断
        int left = 0;
        int right = 0;
        while (right < points.length) {
            while (right < points.length && points[left][1] >= points[right][0]) {
                right++;
            }
            result++;
            left = right;
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons minimumNumberOfArrowsToBurstBalloons =
            new MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(minimumNumberOfArrowsToBurstBalloons.findMinArrowShots(
            new int[][] {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}}));
    }

    public int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
