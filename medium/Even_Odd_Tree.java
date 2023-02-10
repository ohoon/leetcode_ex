/*
1609.
Even Odd Tree
https://leetcode.com/problems/even-odd-tree/
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
    public boolean isEvenOddTree(TreeNode root) {           // BFS
        Deque<TreeNode> deq = new LinkedList<>();
        int level = 0;
        deq.addLast(root);
        while (!deq.isEmpty()) {
            int size = deq.size();
            int prev = -1;
            for (int i = 0; i < size; i++) {
                TreeNode node = deq.removeFirst();
                if (level % 2 == 0 && (node.val % 2 == 0 || prev >= node.val)) {
                    return false;
                }

                if (level % 2 == 1 && (node.val % 2 == 1 || (prev != -1 && prev <= node.val))) {
                    return false;
                }

                if (node.left != null) {
                    deq.addLast(node.left);
                }

                if (node.right != null) {
                    deq.addLast(node.right);
                }

                prev = node.val;
            }

            level++;
        }

        return true;
    }
}
