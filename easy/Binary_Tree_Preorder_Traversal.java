/*
144.
Binary Tree Preorder Traversal
https://leetcode.com/problems/binary-tree-preorder-traversal/
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if(root != null) {
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                answer.add(cur.val);                // root node부터 answer에 삽입
                if (cur.right != null) {            // 우측 자식 노드부터 스택에 넣어서 pop할시 좌측 자식 노드부터 탐색하도록 설정
                    stack.push(cur.right);
                }

                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
Memory Usage: 37.2 MB, less than 67.62% of Java online submissions for Binary Tree Preorder Traversal.
*/
