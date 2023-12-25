package com.algorithms.wz.data.structure.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/top-k-frequent-elements/description/">347.前 K 个高频元素</a>
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class TopKFrequentElements {

    /**
     * 可以使用大顶堆试试看
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<int[]> bigHeap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历计算出现的次数
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            bigHeap.add(new int[]{integerIntegerEntry.getKey(), integerIntegerEntry.getValue()});
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = bigHeap.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] ints = topKFrequentElements.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] topKFrequent2(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历计算出现的次数
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (minHeap.size() == k) {
                if(minHeap.peek()[1] < integerIntegerEntry.getValue()) {
                    minHeap.poll();
                    minHeap.add(new int[]{integerIntegerEntry.getKey(), integerIntegerEntry.getValue()});
                }
            } else {
                minHeap.add(new int[]{integerIntegerEntry.getKey(), integerIntegerEntry.getValue()});
            }

        }
        for (int i = 0; i < result.length; i++) {
            result[i] = minHeap.poll()[0];
        }
        return result;
    }

}
