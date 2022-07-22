/*
2265.
Count Nodes Equal to Average of Subtree
https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
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
    private int answer = 0;
    
    private int[] dfs(TreeNode node) {      // 깊이우선 탐색
        if (node == null) {
            return new int[2];
        }
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] result = new int[]{left[0] + right[0] + node.val, left[1] + right[1] + 1};        // result = {sum, count};
        if (result[0] / result[1] == node.val) {
            answer++;
        }
        
        return result;
    }
    
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 51.52% of Java online submissions for Count Nodes Equal to Average of Subtree.
Memory Usage: 44 MB, less than 55.24% of Java online submissions for Count Nodes Equal to Average of Subtree.
*/
