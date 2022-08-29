/*
1123.
Lowest Common Ancestor of Deepest Leaves
https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
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
	public TreeNode lcaDeepestLeaves(TreeNode root) {
		if (root == null) {
			return null;
		}

		int left = depth(root.left);
		int right = depth(root.right);
		if (left == right) {
			return root;
		}
        
        if (left > right) {
			return lcaDeepestLeaves(root.left);
		}
        
		return lcaDeepestLeaves(root.right);
	}

	private int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
        
		return 1 + Math.max(depth(root.left), depth(root.right));
	}
}

/*
Runtime: 1 ms, faster than 85.54% of Java online submissions for Lowest Common Ancestor of Deepest Leaves.
Memory Usage: 41.8 MB, less than 97.97% of Java online submissions for Lowest Common Ancestor of Deepest Leaves.
*/

/*
잘못 풀었던 풀이

class Solution {
    private int[] dfs(TreeNode node, int depth, int min) {
        if (node.left == null && node.right == null) {
            return new int[]{depth, min};
        }
        
        int[] left = node.left != null ? dfs(node.left, depth + 1, Math.min(min, node.left.val)) : new int[]{-1, Integer.MAX_VALUE};
        int[] right = node.right != null ? dfs(node.right, depth + 1, Math.min(min, node.right.val)) : new int[]{-1, Integer.MAX_VALUE};
        if (left[0] > right[0]) {
            return left;
        }
        
        if (left[0] < right[0]) {
            return right;
        }
        
        if (left[1] < right[1]) {
            return left;
        }
        
        return right;
    }
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root, 0, root.val);
    }
}

문제를 잘못 해석해서 공통 조상 중에서 가장 작은 값을 반환하는줄로 알고 풀었다...
의도와는 다르게 풀었지만 그래도 의도대로 잘 작동하므로 괜찮지 않을까 싶다

*/
