'''
572.
Subtree of Another Tree
https://leetcode.com/problems/subtree-of-another-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSubtree(self, s: TreeNode, t: TreeNode) -> bool:
        if not s:
            return False
        
        def isEqual(n1: TreeNode, n2: TreeNode) -> bool:            # n1과 n2가 동일한 구조와 값을 가지는 트리 쌍인지 확인하는 함수
            if not n1 and not n2:
                return True
            
            if not n1 or not n2:
                return False
            
            if n1.val != n2.val:
                return False
            
            return isEqual(n1.left, n2.left) and isEqual(n1.right, n2.right)
        
        if s.val == t.val and isEqual(s, t):                        # s에서 t의 루트 노드와 같은 노드를 찾아서 해당 서브 트리가 t와 같은지 확인
            return True
        
        return self.isSubtree(s.left, t) or self.isSubtree(s.right, t)          # t의 루트 노드와 같은 값을 가지는 노드를 탐색

'''
Runtime: 232 ms, faster than 73.83% of Python3 online submissions for Subtree of Another Tree.
Memory Usage: 15.6 MB, less than 6.05% of Python3 online submissions for Subtree of Another Tree.
'''