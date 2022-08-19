/*
1026.
Maximum Difference Between Node and Ancestor
https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
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
class Solution {                                                // 깊이 우선 탐색
    private int dfs(TreeNode node, int max, int min) {
        if (node == null) {
            return 0;
        }
        
        int result = Math.max(Math.abs(max - node.val), Math.abs(min - node.val));      // 현재 노드와 max, min 값을 비교하여 갱신
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        result = Math.max(result, dfs(node.left, max, min));        // 좌, 우 자식 노드들도 깊이 우선 탐색으로 결과값을 가져와서 비교
        result = Math.max(result, dfs(node.right, max, min));
        return result;
    }
    
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
}

/*
Runtime: 1 ms, faster than 70.91% of Java online submissions for Maximum Difference Between Node and Ancestor.
Memory Usage: 42 MB, less than 89.05% of Java online submissions for Maximum Difference Between Node and Ancestor.
*/
