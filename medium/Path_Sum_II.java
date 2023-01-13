/*
113.
Path Sum II
https://leetcode.com/problems/path-sum-ii/
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {      // DFS
        List<List<Integer>> pathList = new ArrayList<>();       // 내부의 List는 addFirst를 사용하기 위해 연결리스트 사용
        if (root == null) {
            return pathList;
        }
        
        if (root.left == null && root.right == null && root.val == targetSum) {
            pathList.add(new LinkedList<>());
        }

        if (root.left != null) {
            pathList.addAll(pathSum(root.left, targetSum - root.val));
        }

        if (root.right != null) {
            pathList.addAll(pathSum(root.right, targetSum - root.val));
        }

        for (List<Integer> path : pathList) {
            ((LinkedList) path).addFirst(root.val);
        }

        return pathList;
    }
}
