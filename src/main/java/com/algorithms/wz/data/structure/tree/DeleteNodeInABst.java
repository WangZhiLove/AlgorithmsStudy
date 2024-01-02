package com.algorithms.wz.data.structure.tree;

/**
 * <a href="https://leetcode.cn/problems/delete-node-in-a-bst/description/">450.删除二叉搜索树中的节点</a>
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 */
public class DeleteNodeInABst {

    /**
     * 还是递归的实现，判断一个节点是否等于 key，如果等于，就用当前节点的右节点替换当前节点，然后把当前节点的左节点等于替换节点的左节点的叶子节点
     *
     * @param root 根节点
     * @param key  要删除的节点的值
     * @return 返回删除后的节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        // 移除节点
        if (root.val == key) {
            return delTargetNode(root);
        }
        // 判断 key 是在左边还是右边，进而递归相应的子树
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode delTargetNode(TreeNode root) {
        // 判断如果对应的左树或者右树有一个是 null，直接返回另外一个
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode left = root.left;
        // 循环将左树插入到右树的左子树的根节点
        TreeNode right = root.right;
        while (right.left != null) {
            right = right.left;
        }
        right.left = left;
        return root.right;
    }

}
