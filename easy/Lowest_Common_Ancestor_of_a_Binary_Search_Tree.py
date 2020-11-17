'''
235.
Lowest Common Ancestor of a Binary Search Tree
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
'''

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if (p.val <= root.val <= q.val) or (q.val <= root.val <= p.val):        # p와 q 값 사이에 현재 노드 값이 위치하면 해당 노드 반환
            return root
        
        if p.val <= root.val:       # p와 q 값보다 현재 노드 값이 클 때 왼쪽으로 탐색
            return self.lowestCommonAncestor(root.left, p, q)
        
        if root.val <= p.val:       # p와 q 값보다 현재 노드 값이 작을 때 오른쪽으로 탐색
            return self.lowestCommonAncestor(root.right, p, q)

'''
Runtime: 76 ms, faster than 73.85% of Python3 online submissions for Lowest Common Ancestor of a Binary Search Tree.
Memory Usage: 18 MB, less than 16.53% of Python3 online submissions for Lowest Common Ancestor of a Binary Search
'''