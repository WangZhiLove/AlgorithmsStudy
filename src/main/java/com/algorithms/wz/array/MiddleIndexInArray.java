package com.algorithms.wz.array;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/find-the-middle-index-in-numsay/">1991. 找到数组的中间位置</a>
 *
 * @author wangzhi
 */
public class MiddleIndexInArray {

    public static void main(String[] args) {
        System.out.println(findMiddleIndex(new int[] {1, 7, 3, 6, 5, 6}));
        System.out.println(findMiddleIndex(new int[] {1, 2, 3}));
        System.out.println(findMiddleIndex(new int[] {2, 1, -1}));
        System.out.println(findMiddleIndex(new int[] {3, 2, -1, -4, 8}));
        System.out.println(findMiddleIndex(new int[] {1, -1, 4}));
    }

    /**
     * 前缀和的思路，有点数学推理，其实算法就是和数学相关的，没想到过了这么久我还是不习惯用数学的思维思考呀。
     * 思路是：遍历数组，针对于索引为 i 的元素来说，左侧元素之和为 leftSum，元素总和为 sum，则右侧元素为 sum - leftSum - nums[i]，左右元素
     * 之和相等，意味着：leftSum = sum - leftSum - nums[i]，转换一下就是 2 * leftSum + nums[i] = sum，使用这个来解决看看，接着如果索引
     * 左侧或右侧没有元素，这个在数学上叫做空和。
     *
     * @param nums 数组
     * @return 中间索引
     */
    private static int findMiddleIndex(int[] nums) {
        // 没有经过严格的验证，但是经过两三次测试，发现 stream 的效率没有 for 循环高，无论是时间还是空间
        int sum = sum(nums, 0, nums.length - 1);
        /// int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * leftSum + nums[i] == sum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    private static int sum(int[] nums, int leftIndex, int rightIndex) {
        int result = 0;
        for (int i = leftIndex; i <= rightIndex; i++) {
            result += nums[i];
        }
        return result;
    }

    /**
     * 将特殊情况排除，双层 for 循环来判断中间索引值
     * 有没有什么更简单的方法呢？双指针的方法可不可以使用呢？
     *
     * @param nums 数组
     * @return 中间索引
     */
    private static int findMiddleIndex2(int[] nums) {
        // 特殊情况排除
        if (nums.length == 0 || sum(nums, 0, nums.length - 1) - nums[0] == 0) {
            return 0;
        }
        int result = 2;
        while (result <= nums.length - 1) {
            if (sum(nums, result, nums.length - 1) - sum(nums, 0, result - 2) == 0) {
                return result - 1;
            }
            result++;
        }
        // 特殊情况排除
        if (sum(nums, 0, nums.length - 1) - nums[nums.length - 1] == 0) {
            return nums.length - 1;
        }
        return -1;
    }
}
