/*
129.
Sum Root to Leaf Numbers
https://leetcode.com/problems/sum-root-to-leaf-numbers/
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
    private int dfs(TreeNode root, int parent) {            // DFS
        int num = parent * 10 + root.val;       // 자식노드로 갈수록 값이 누적됨
        if (root.left == null && root.right == null) {      // 단말노드에 도착하면 순회 종료
            return num;
        }

        return (root.left != null ? dfs(root.left, num) : 0) + (root.right != null ? dfs(root.right, num) : 0);
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
}
