/*
103.
Binary Tree Zigzag Level Order Traversal
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {        // BFS
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> answer = new ArrayList<>();
        Deque<TreeNode> deq = new LinkedList<>();
        boolean reverse = false;
        deq.addLast(root);
        while (!deq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = deq.size();
            if (!reverse) {         // 정방향일때는 앞에서 remove 뒤로 add
                for (int i = 0; i < size; i++) {
                    TreeNode node = deq.removeFirst();
                    if (node.left != null) {
                        deq.addLast(node.left);
                    }

                    if (node.right != null) {
                        deq.addLast(node.right);
                    }

                    list.add(node.val);
                }
            } else {                // 역방향일때는 뒤에서 remove 앞으로 add
                for (int i = 0; i < size; i++) {
                    TreeNode node = deq.removeLast();
                    if (node.right != null) {
                        deq.addFirst(node.right);
                    }

                    if (node.left != null) {
                        deq.addFirst(node.left);
                    }

                    list.add(node.val);
                }
            }

            answer.add(list);
            reverse = !reverse;
        }

        return answer;
    }
}
