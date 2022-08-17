/*
1325.
Delete Leaves With a Given Value
https://leetcode.com/problems/delete-leaves-with-a-given-value/
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
    public TreeNode removeLeafNodes(TreeNode root, int target) {        // 깊이 우선 탐색
        if (root == null) {
            return null;
        }
        
        root.left = removeLeafNodes(root.left, target);     // dfs 탐색
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {        // leave의 val 값이 target일 경우 null 노드 반환
            return null;
        }
        
        return root;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Leaves With a Given Value.
Memory Usage: 44.2 MB, less than 83.13% of Java online submissions for Delete Leaves With a Given Value.
*/
