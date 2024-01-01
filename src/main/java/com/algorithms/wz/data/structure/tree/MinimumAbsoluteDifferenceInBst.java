package com.algorithms.wz.data.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/">530.二叉搜索树的最小绝对差</a>
 * 给你一个二叉搜索树的根节点`root`，返回**树中任意两不同节点值之间的最小差值**。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class MinimumAbsoluteDifferenceInBst {

    /**
     * 这个是二叉搜索树，但是不能忽略根节点和左子树节点的右节点，也不能忽略根节点和右子树节点的左节点，
     * 那我是不是可以将每一个节点与根节点做比较呢？
     * 超出时间限制，但是思路应该没错，那就换个思路，先遍历，然后再计算就好
     * @param root 根节点
     * @return 差值最小的绝对值
     */
    public int getMinimumDifference(TreeNode root) {
        return Math.min(getMinimum(root.left, root.val), getMinimum(root.right, root.val));
    }

    private int getMinimum(TreeNode root, Integer maxValue) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int minValue1 = Math.min(Math.abs(maxValue - root.val), getMinimum(root.left, maxValue));
        int minValue2 = Math.min(Math.abs(maxValue - root.val), getMinimum(root.right, maxValue));
        int min = Math.min(minValue1, minValue2);
        return Math.min(Math.min(min, getMinimum(root.left, root.val)), getMinimum(root.right, root.val));
    }

    public int getMinimumDifference2(TreeNode root) {
        List<Integer> listValue = new ArrayList<>();
        recursion(root, listValue);
        Integer minValue = Integer.MAX_VALUE;
        for (int i = 1; i < listValue.size(); i++) {
            minValue = Math.min(minValue, listValue.get(i) - listValue.get(i - 1));
        }
        return minValue;
    }

    private void recursion(TreeNode root, List<Integer> listValue) {
        if(root == null) {
            return;
        }
        recursion(root.left, listValue);
        listValue.add(root.val);
        recursion(root.right, listValue);
    }

}
