'''
965.
Univalued Binary Tree
https://leetcode.com/problems/univalued-binary-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isUnivalTree(self, root: TreeNode) -> bool:
        if not root:
            return True
        
        if root.left and root.val != root.left.val:     # 왼쪽 자식 노드 값이 부모 노드 값과 다르면 False 반환
            return False
        
        if root.right and root.val != root.right.val:   # 오른쪽 자식 노드 값이 부모 노드 값과 다르면 False 반환
            return False
        
        return self.isUnivalTree(root.left) and self.isUnivalTree(root.right)       # 양쪽 서브 트리로 재귀하여 탐색

'''
Runtime: 24 ms, faster than 96.69% of Python3 online submissions for Univalued Binary Tree.
Memory Usage: 14.3 MB, less than 21.32% of Python3 online submissions for Univalued Binary Tree.
'''