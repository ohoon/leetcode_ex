/*
145.
Binary Tree Postorder Traversal
https://leetcode.com/problems/binary-tree-postorder-traversal/
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            
            if (stack.peek().right == null || stack.peek().right == prev) {
                prev = stack.pop();
                answer.add(prev.val);
            } else {
                cur = stack.peek().right;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
Memory Usage: 37.6 MB, less than 16.34% of Java online submissions for Binary Tree Postorder Traversal.
*/

/*
여담

preorder 문제와 마찬가지로 반복법으로 풀이하기가 너무 까다롭다.
하나의 포인터로 풀이하기엔 무리가 있어서 prev 포인터를 추가해서 현재 위치가 pop할 위치인지 우측 서브트리로 이동해야하는 위치인지 판단할 수 있도록 하였다.
결국 문제는 다른 사람의 풀이를 보고 이해하게 되어서 시간을 두고 다시 풀어봐야 겠다.

*/
