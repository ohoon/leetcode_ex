/*
958.
Check Completeness of a Binary Tree
https://leetcode.com/problems/check-completeness-of-a-binary-tree/
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
    public boolean isCompleteTree(TreeNode root) {      // BFS
        Deque<TreeNode> deq = new LinkedList<>();
        boolean isEndNode = false;
        deq.addLast(root);
        while (!deq.isEmpty()) {
            int size = deq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deq.removeFirst();
                if (isEndNode && (node.left != null || node.right != null)) {       // EndNode가 나왔는데 새로운 노드가 등장하면 false
                    return false;
                }

                if (node.left == null && node.right != null) {      // 왼쪽 자식노드 > 오른쪽 자식노드 순서가 아닌경우 false
                    return false;
                }

                if (node.left != null) {
                    deq.addLast(node.left);
                }

                if (node.right != null) {
                    deq.addLast(node.right);
                } else {
                    isEndNode = true;
                }
            }
        }

        return true;
    }
}
