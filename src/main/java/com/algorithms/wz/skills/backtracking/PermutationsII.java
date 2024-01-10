package com.algorithms.wz.skills.backtracking;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/permutations-ii/description/">47.全排列 II</a>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class PermutationsII {

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> temp = new ArrayList<>();

    boolean[] visit;

    /**
     * 相对于全排列来说，数组包含了重复元素，这个是要需要考虑的，其实也好解决，我单独声明一个存放索引的集合就可以，试试看
     * 思考错了，不是索引去重，先用 Hash 去重
     * @param nums 数组
     * @return 集合
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visit = new boolean[nums.length];
        backtracking(nums);
        return result;
    }

    private void backtracking(int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 已经访问过
            if (visit[i]) {
                continue;
            }
            // 如果当前层下一个元素和当前元素相同，并且前一个元素未被访问，则跳过，简单就是说访问过添加，未被访问，跳过
            // 为什么是未被访问，因为这是当前层，当前层如果前一个元素被访问了，则相同元素就可以被添加，组成 1-1-2
            // 如果是未被访问，则说明第一个 1 已经被访问过了，那么第二个 1 会得到和第一个 1 相同的结果，则直接跳过，层的跳过
            if (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1]) {
                continue;
            }
            visit[i] = true;
            temp.add(nums[i]);
            backtracking(nums);
            visit[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();
        List<List<Integer>> lists = permutationsII.permuteUnique(new int[] {1, 1, 2});
        lists.forEach(System.out::println);
    }

}
