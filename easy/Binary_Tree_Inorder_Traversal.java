/*
94.
Binary Tree Inorder Traversal
https://leetcode.com/problems/binary-tree-inorder-traversal/
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            answer.add(cur.val);
            cur = cur.right;
        }

        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
Memory Usage: 37.5 MB, less than 22.22% of Java online submissions for Binary Tree Inorder Traversal.
*/

/*
여담

이 문제를 순회 방식으로 풀이하는 것은 쉽다.
inorder에 맞게 left인 경우 순회, 현재 노드의 값 추가, right인 경우 순회 순서로 구현하면 되는 간단한 문제다.
하지만 반복법으로 풀이하기 위해서 어떤 코드를 짜야하는지 어려움을 겪었다.
코드를 다시 보고 생각을 정리해서 완전히 익힐 수 있도록 하자.

*/
