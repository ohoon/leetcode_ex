/*
1080.
Insufficient Nodes in Root to Leaf Paths
https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
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
    public TreeNode sufficientSubset(TreeNode root, int limit) {        // DFS
        if (root.left == null && root.right == null) {      // 단말노드이면 limit 체크하여 조건에 부합하면 null 노드 반환
            return limit > root.val ? null : root;
        }

        if (root.left != null) {
            root.left = sufficientSubset(root.left, limit - root.val);      // 왼쪽 자식 노드가 조건에 부합하면 연결이 끊김
        }

        if (root.right != null) {
            root.right = sufficientSubset(root.right, limit - root.val);    // 왼쪽과 동일
        }

        return root.left == null && root.right == null ? null : root;       // 모든 자식 노드와 연결이 끊으면 자기 자신도 null 노드로 
    }
}
