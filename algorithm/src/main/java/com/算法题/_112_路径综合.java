package com.算法题;

import com.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class _112_路径综合 {

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            dfs(list, root, targetSum, result);
            return list;

        }

        private void dfs(List<List<Integer>> list, TreeNode root, int targetSum, List<Integer> result) {
            if (root == null) {
                return;
            }
            result.add(root.val);
            if (root.left == null && root.right == null) {
                if (targetSum - root.val == 0) {
                    list.add(new ArrayList<>(result));
                }
            }
            dfs(list, root.left, targetSum - root.val, result);
            dfs(list, root.right, targetSum - root.val, result);
            // 还原现场：先添加，用完之后，就移除。
            result.remove(result.size() - 1);
        }
    }


}