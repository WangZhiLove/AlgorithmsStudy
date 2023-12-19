package com.algorithms.wz.data.structure.hash;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/4sum/description/">18.四数之和</a>
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * @author wangzhi
 */
public class FourSum {

    /**
     * 借助三数之和的思路试试看
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            List<List<Integer>> list = myThreeSum(nums, target - nums[i], i + 1);
            for (List<Integer> threeList : list) {
                threeList.add(nums[i]);
                result.add(threeList);
            }
        }
        return result;
    }

    private List<List<Integer>> myThreeSum(int[] nums, long target, int index) {
        Set<List<Integer>> result = new HashSet<>();
        for (int i = index; i < nums.length - 2; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] > target) {
                break;
            }
            if ((long) nums[i] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if ((long) nums[i] + nums[left] + nums[right] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    left ++;
                    right --;
                    result.add(list);
                } else if (nums[i] + nums[left] + nums[right] > target) {
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        List<List<Integer>> lists =
            fourSum.fourSum(new int[] {1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
