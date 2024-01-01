package com.algorithms.wz.data.structure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/validate-binary-search-tree/description/">98.验证二叉搜索树</a>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class ValidateBinarySearchTree {

    /**
     * 可以中序遍历，结束之后 copy 一份数据，然后将拷贝出来的数据进行排序
     * @param root 根节点
     * @return 是否是二差搜索树
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        recursion(root, values);
        int[] valuesArr = new int[values.size()];
        for (int i = 0; i < valuesArr.length; i++) {
            valuesArr[i] = values.get(i);
        }
        Arrays.sort(valuesArr);
        for (int i = 0; i < valuesArr.length; i++) {
            if (i > 0 && valuesArr[i] == valuesArr[i - 1]) {
                return false;
            }
            if(valuesArr[i] != values.get(i)) {
                return false;
            }
         }
        return true;
    }

    private void recursion(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        recursion(root.left, values);
        values.add(root.val);
        recursion(root.right, values);
    }

    /**
     * 在递归的时候确定上下值，就是确定当前这个节点的最大值和最小值，如果不在这个范围就是不符合要求
     * @param root 根节点
     * @return 是否为二叉搜索树
     */
    public boolean isValidBST2(TreeNode root) {
        return recursion2(root, null, null);

    }

    /**
     * 递归判断树是否是二叉搜索树
     * @param root 根节点
     * @param down 当前节点的最小值
     * @param up  当前节点的最大值
     * @return 是否是二叉搜索树
     */
    private boolean recursion2(TreeNode root, Integer down, Integer up) {
        if (root == null) {
            return true;
        }
        if ((down != null && root.val <= down) || (up != null && root.val >= up)) {
            return false;
        }
        return recursion2(root.left, down, root.val) && recursion2(root.right, root.val, up);
    }

}
