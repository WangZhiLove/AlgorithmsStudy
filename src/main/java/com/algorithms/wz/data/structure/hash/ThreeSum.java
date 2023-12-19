package com.algorithms.wz.data.structure.hash;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/3sum/description/">15. 三数之和</a>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {

    /**
     * 考虑两数之和，外层 for 循环，内层两数之和，做出来了，但是效果不好
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> list = myTwoSum(nums, -nums[i], i);
            for (int j = 0; j < list.size(); j++) {
                list.get(j).add(nums[i]);
                // 排序，外部 set 去重
                Collections.sort(list.get(j));
            }
            if (!list.isEmpty()) {
                result.addAll(list);
            }
        }
        return new ArrayList<>(result);
    }

    private static List<List<Integer>> myTwoSum(int[] nums, int target, int index) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = index + 1; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(target - nums[i]);
                result.add(temp);
            }
            set.add(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum2(new int[] {-1,0,1,2,-1,-4});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    /**
     * 排序 + 双指针
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 重复判断，减少了 while 循环的次数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left ++;
                    right --;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
