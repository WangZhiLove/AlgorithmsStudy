package com.algorithms.wz.one.day.year24.month3;

/**
 * <a href="https://leetcode.cn/problems/range-sum-query-immutable/description/">303. 区域和检索 - 数组不可变</a>
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 * <p>
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 */
public class RangeSumQueryImmutable {

}

/**
 * 这道题目有点意思，原来还可以这么做，我的做法是寻常做法，就是索引遍历求和，是在 sumRange 上实现求和。看了题解另外一种做法：
 * <p>
 * 这种做法效率比这个高很多，是这样做的，我在进行构造数组的时候，我的每一位是前面所有元素 + 当前位元素的和，这样在计算求和的时候使用索引减一下就可以
 */
class NumArray {

    int[] arr;

    public NumArray(int[] nums) {
        arr = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        while (left <= right) {
            sum += arr[left];
            left++;
        }
        return sum;
    }
}

class NumArray1 {

    int[] arr;

    public NumArray1(int[] nums) {
        // 为什么要这么做，不能直接让 arr 的长度等于 nums 长度吗？当然也可以，只不过如果这么做了，那计算方式就不统一了
        // 计算 arr[0] = arr[0], arr[1] = arr[2] - arr[1]
        // 但是现在这种做法就是 arr[0] = arr[1] - arr[0], arr[1] = arr[2] - arr[1]
        arr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i] + arr[i];
        }
    }

    public int sumRange(int left, int right) {
        return arr[right + 1] - arr[left];
    }
}

