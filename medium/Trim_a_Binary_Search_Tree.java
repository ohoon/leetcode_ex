/*
669.
Trim a Binary Search Tree
https://leetcode.com/problems/trim-a-binary-search-tree/
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {     // null 노드 처리
            return null;
        }
        
        if (root.val < low) {   // 현재 노드의 값이 low값보다 작으면 자신과 왼쪽 자식노드를 버리고 오른쪽 자식 노드로 순회
            return trimBST(root.right, low, high);
        }
        
        if (root.val > high) {      // 현재 노드의 값이 high보다 크면 자신과 오른쪽 자식노드를 버리고 왼쪽 자식 노드로 순회
            return trimBST(root.left, low, high);
        }
        
        root.left = trimBST(root.left, low, high);      // 현재 노드의 값이 범위 안에 들면 양쪽 자식 노드로 순회하여 자식 노드 관계를 재설정
        root.right = trimBST(root.right, low, high);
        return root;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Trim a Binary Search Tree.
Memory Usage: 41.9 MB, less than 84.81% of Java online submissions for Trim a Binary Search Tree.
*/
