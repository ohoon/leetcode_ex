/*
114.
Flatten Binary Tree to Linked List
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        TreeNode left = root.left;      // 좌우 서브트리 백업
        TreeNode right = root.right;
        root.left = null;       // 왼쪽 서브트리 연결을 끊음
        
        flatten(left);          // 좌우 서브트리 순회
        flatten(right);
        
        root.right = left;      // 왼쪽 서브트리를 오른쪽으로 이동
        TreeNode cur = root;
        while (cur.right != null) {     // 왼쪽 서브트리의 가장 오른쪽 아래 노드의 right를 현재 노드의 right으로 지정
            cur = cur.right;
        }
        
        cur.right = right;
    }
}

/*
Runtime: 1 ms, faster than 84.28% of Java online submissions for Flatten Binary Tree to Linked List.
Memory Usage: 43.2 MB, less than 13.22% of Java online submissions for Flatten Binary Tree to Linked List.
*/

/*
나의 풀이

class Solution {
    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        if (root.left == null && root.right == null) {
            return root;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            root.left = null;
            root.right = left;
            dfs(left).right = right;
        }
        
        return right != null ? right : root;
    }
    
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        dfs(root);
    }
}

문제에 명시된 테스트케이스는 통과됐지만 모든 테스트케이스를 통과하지 못했음
/ 모양으로 트리가 구성되었을경우 right 부분을 해결못해서 막힌듯하다.

*/
