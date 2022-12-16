/*
623.
Add One Row to Tree
https://leetcode.com/problems/add-one-row-to-tree/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {          // dfs
        if (root == null) {
            return null;
        }

        if (depth == 1) {       // 새롭게 추가된 row가 root가 되는 경우
            return new TreeNode(val, root, null);
        }

        if (depth == 2) {       // 새롭게 추가된 row가 자식 노드가 되는 경우
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = new TreeNode(val, left, null);
            root.right = new TreeNode(val, null, right);
            return root;
        }

        addOneRow(root.left, val, depth - 1);       // 좌우 서브트리로 순회
        addOneRow(root.right, val, depth - 1);
        return root;
    }
}
