'''
110.
Balanced Binary Tree
https://leetcode.com/problems/balanced-binary-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def getMaxDepth(self, node: TreeNode) -> int:       # root의 서브 트리를 탐색
        if not node:
            return 0
        
        left = self.getMaxDepth(node.left)
        right = self.getMaxDepth(node.right)
        
        if left == -1 or right == -1 or abs(left - right) > 1:      # 해당 node 또는 서브 트리에서 좌/우 노드의 깊이 차이가 1 초과이면 -1 반환
            return -1
        
        return max(left, right) + 1     # 깊은 것 기준으로 깊이 +1 증가하며 상위 노드로
    
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        
        left = self.getMaxDepth(root.left)
        right = self.getMaxDepth(root.right)
        
        if left == -1 or right == -1 or abs(left - right) > 1:      # root의 서브 트리 또는 이전 작업에서 깊이 차이가 1 초과한 서브 트리가 존재하면 False 반환
            return False
        
        return True

'''
Runtime: 44 ms, faster than 92.75% of Python3 online submissions for Balanced Binary Tree.
Memory Usage: 18 MB, less than 39.76% of Python3 online submissions for Balanced Binary Tree.
'''