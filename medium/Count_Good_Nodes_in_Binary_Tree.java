/*
1448.
Count Good Nodes in Binary Tree
https://leetcode.com/problems/count-good-nodes-in-binary-tree/
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
class Solution {                                    // 깊이 우선 탐색
    private int dfs(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        
        max = Math.max(max, node.val);
        return (node.val >= max ? 1 : 0) + dfs(node.left, max) + dfs(node.right, max);      // 최고값을 갱신하면서 good node인지 검증
    }
    
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
}

/*
Runtime: 3 ms, faster than 77.00% of Java online submissions for Count Good Nodes in Binary Tree.
Memory Usage: 59.9 MB, less than 36.75% of Java online submissions for Count Good Nodes in Binary Tree.
*/
