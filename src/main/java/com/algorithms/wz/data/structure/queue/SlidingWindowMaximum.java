package com.algorithms.wz.data.structure.queue;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/sliding-window-maximum/description/">239. 滑动窗口最大值</a>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 */
public class SlidingWindowMaximum {

    /**
     * 超出时间限制
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> resultList = new ArrayList<>();
        int left = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (i - left + 1 >= k) {
                resultList.add(max);
                left++;
                // 重新计算区间的最大值
                if (max == nums[left - 1] && left < nums.length) {
                    int temp = left;
                    max = nums[temp];
                    while (++temp <= i) {
                        max = Math.max(max, nums[temp]);
                    }
                }
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] ints = slidingWindowMaximum.maxSlidingWindow2(new int[] {9, 10, 9, -7, -4, -8, 2, -6}, 5);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 使用优先队列看看吧
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() == k) {
                result[left] = queue.peek();
                queue.remove(nums[left]);
                left++;
            }
        }
        return result;
    }

    /**
     * 使用优先队列变种
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        // 先按照值降序排序，再按照索引降序排序
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        // 先将前 k 个入列
        for (int i = 0; i < k; i++) {
            queue.offer(new int[] {nums[i], i});
        }
        result[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.add(new int[] {nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            result[i - k + 1] = queue.peek()[0];
        }
        return result;
    }

    /**
     * 单个队列,思路就是只保留比插入元素大的元素，不保留比插入元素小的元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow4(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        // 存放索引
        Deque<Integer> queue = new LinkedList<>();
        // 先将前 k 个入列
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        result[0] = nums[queue.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            while (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            result[i - k + 1] = nums[queue.peekFirst()];
        }
        return result;
    }

}
