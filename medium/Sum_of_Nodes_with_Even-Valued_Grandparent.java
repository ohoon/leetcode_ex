/*
1315.
Sum of Nodes with Even-Valued Grandparent
https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
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
    private int sum(TreeNode node, int pv) {
        if (node == null || (node.left == null && node.right == null)) {        // 존재하지 않는 노드거나 단말 노드의 경우에 0 반환
            return 0;
        }
        
        int res = sum(node.left, node.val) + sum(node.right, node.val);         // 자식 노드로 순회한 결과
        if (pv % 2 == 0) {              // 부모 노드가 짝수인 경우, 자식 노드의 값 합을 res에 더해줌
            res += (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);
        }
        
        return res;
    }
    
    public int sumEvenGrandparent(TreeNode root) {
        return sum(root.left, root.val) + sum(root.right, root.val);
    }
}

/*
Runtime: 2 ms, faster than 85.81% of Java online submissions for Sum of Nodes with Even-Valued Grandparent.
Memory Usage: 52.3 MB, less than 44.89% of Java online submissions for Sum of Nodes with Even-Valued Grandparent.
*/
