/*
1302.
Deepest Leaves Sum
https://leetcode.com/problems/deepest-leaves-sum/
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
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> deq = new LinkedList<>();
        deq.add(root);
        while (!deq.isEmpty()) {        // 너비우선 탐색
            sum = 0;                    // 깊이마다 sum 초기화
            int size = deq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deq.removeFirst();
                sum += node.val;
                if (node.left != null) {
                    deq.add(node.left);
                }
                
                if (node.right != null) {
                    deq.add(node.right);
                }
            }
        }
        
        return sum;     // 가장 깊은 깊이에서의 sum 값을 반환
    }
}

/*
Runtime: 12 ms, faster than 26.27% of Java online submissions for Deepest Leaves Sum.
Memory Usage: 59.6 MB, less than 14.27% of Java online submissions for Deepest Leaves Sum.
*/
