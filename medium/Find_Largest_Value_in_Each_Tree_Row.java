/*
515.
Find Largest Value in Each Tree Row
https://leetcode.com/problems/find-largest-value-in-each-tree-row/
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {          // BFS, 너비우선 탐색
            int max = Integer.MIN_VALUE;
            int n = q.size();           // 현재 row에 해당하는 노드들만 poll하기 위함
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            
            answer.add(max);
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 47.46% of Java online submissions for Find Largest Value in Each Tree Row.
Memory Usage: 45 MB, less than 42.43% of Java online submissions for Find Largest Value in Each Tree Row.
*/
