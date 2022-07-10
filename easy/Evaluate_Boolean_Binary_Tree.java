/*
2331.
Evaluate Boolean Binary Tree
https://leetcode.com/problems/evaluate-boolean-binary-tree/
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
    public boolean evaluateTree(TreeNode root) {
        switch (root.val) {
            case 0: return false;
            case 1: return true;
            case 2: return evaluateTree(root.left) || evaluateTree(root.right);
            case 3: return evaluateTree(root.left) && evaluateTree(root.right);
        }
        
        return false;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Evaluate Boolean Binary Tree.
Memory Usage: 42 MB, less than 100.00% of Java online submissions for Evaluate Boolean Binary Tree.
*/
