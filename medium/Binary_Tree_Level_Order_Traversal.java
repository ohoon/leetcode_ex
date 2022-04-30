/*
102.
Binary Tree Level Order Traversal
https://leetcode.com/problems/binary-tree-level-order-traversal/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {         // 노드가 없는 트리일 경우
            return answer;
        }
        
        Deque<TreeNode> deq = new LinkedList<>();       // queue용으로 사용
        deq.offer(root);
        while (!deq.isEmpty()) {
            List<Integer> list = new ArrayList<>();     // 현재 depth에 있는 노드들의 val을 담을 리스트
            int size = deq.size();
            for (int i = 0; i < size; i++) {        // 현재 depth의 노드들을 꺼내서 list에 val 값을 삽입, 자식 노드들은 deq에 넣는 것만 수행함
                TreeNode node = deq.pollFirst();
                list.add(node.val);
                if (node.left != null) {        // 자식노드들을 deq에 삽입
                    deq.offer(node.left);
                }
                
                if (node.right != null) {
                    deq.offer(node.right);
                }
            }
            
            answer.add(list);
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 81.65% of Java online submissions for Binary Tree Level Order Traversal.
Memory Usage: 43.8 MB, less than 34.04% of Java online submissions for Binary Tree Level Order Traversal.
*/
