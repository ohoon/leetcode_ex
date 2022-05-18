/*
1379.
Find a Corresponding Node of a Binary Tree in a Clone of That Tree
https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {        // 깊이 우선 탐색
        if (original == null) {
            return null;
        }
        
        if (original == target) {       // target 노드를 발견하면 cloned의 노드를 반환
            return cloned;
        }
        
        TreeNode left = getTargetCopy(original.left, cloned.left, target);      // 좌측 트리 탐색
        if (left != null) {     // 좌측 트리에서 target을 발견하면
            return left;
        }

        TreeNode right = getTargetCopy(original.right, cloned.right, target);   // 우측 트리 탐색
        if (right != null) {    // 우측 트리에서 target을 발견하면
            return right;
        }
        
        return null;        // 자식 노드가 없고 target 노드를 발견하지 못하면 그대로 null 반환
    }
}

/*
Runtime: 3 ms, faster than 43.71% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.
Memory Usage: 101.3 MB, less than 57.39% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.
*/
