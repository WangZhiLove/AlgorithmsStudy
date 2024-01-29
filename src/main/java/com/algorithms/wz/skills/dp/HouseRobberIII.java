package com.algorithms.wz.skills.dp;

import com.algorithms.wz.data.structure.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/house-robber-iii/description/">337.打家劫舍III</a>
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * <p>
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * <p>
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 */
public class HouseRobberIII {

    /**
     * 树形 dp，dp + 树 = dp + 递归，不容易呀
     *
     * @param root 树的根节点
     * @return 不触动警报的情况下，小偷盗取的最高金额
     */
    public int rob(TreeNode root) {
        // dp 有两个元素，索引 0 表示取根节点的最高金额，索引 1 表示不取根节点的最高金额
        int[] dp = recursion(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] recursion(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        // 计算左子树在取根节点和不取根节点的最大值
        int[] left = recursion(root.left);
        int[] right = recursion(root.right);
        // 不取根节点的最大值就是 left 和 right 在取根节点以及不取根节点之间的最大值
        int noRootMax = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int rootMax = root.val + left[1] + right[1];
        return new int[]{rootMax, noRootMax};
    }

    public static void main(String[] args) {

    }
}
