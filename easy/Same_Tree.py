'''
100.
Same Tree
https://leetcode.com/problems/same-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if not (p or q):        # p, q 둘다 null일 경우 단말 노드이므로 True
            return True
        
        if not (p and q):       # p, q 둘 중 하나만 null일 경우 같은 트리가 아니므로 False
            return False
        
        if p.val != q.val:      # p, q의 val 값이 서로 다를 경우 False
            return False
        
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)        # p, q val 값이 서로 같고, 비단말 노드면 left 노드와 right 노드를 재귀 검사

'''
Runtime: 24 ms, faster than 94.11% of Python3 online submissions for Same Tree.
Memory Usage: 14.1 MB, less than 99.99% of Python3 online submissions for Same Tree.
'''