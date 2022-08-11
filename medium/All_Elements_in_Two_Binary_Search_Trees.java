/*
1305.
All Elements in Two Binary Search Trees
https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
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
    private void inorder(TreeNode root, List<Integer> list) {       // inorder 순으로 list에 val값을 넣는 메서드
        if (root == null) {
            return;
        }
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);      // 트리1과 트리2의 각 val들을 inorder순으로 정리
        inorder(root2, list2);
        int cur1 = 0, cur2 = 0;
        while (cur1 < list1.size() || cur2 < list2.size()) {
            if (cur1 == list1.size()) {
                answer.add(list2.get(cur2++));
                continue;
            }
            
            if (cur2 == list2.size()) {
                answer.add(list1.get(cur1++));
                continue;
            }
            
            answer.add(list1.get(cur1) < list2.get(cur2) ? list1.get(cur1++) : list2.get(cur2++));      // list1, list2를 비교하여 오름차순으로 병합
        }
        
        return answer;
    }
}

/*
Runtime: 25 ms, faster than 64.57% of Java online submissions for All Elements in Two Binary Search Trees.
Memory Usage: 68.2 MB, less than 73.26% of Java online submissions for All Elements in Two Binary Search Trees.
*/
