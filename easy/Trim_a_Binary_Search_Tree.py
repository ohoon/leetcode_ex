'''
669.
Trim a Binary Search Tree
https://leetcode.com/problems/trim-a-binary-search-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def trimBST(self, root: TreeNode, low: int, high: int) -> TreeNode:
        if not root:
            return None
        
        if root.val < low:          # 노드 값이 low보다 작으면 보다 값이 큰 우측 노드로 재귀
            return self.trimBST(root.right, low, high)
        
        if root.val > high:         # 노드 값이 high보다 크면 보다 값이 작은 좌측 노드로 재귀
            return self.trimBST(root.left, low, high)
        
        root.left = self.trimBST(root.left, low, high)      # 좌, 우측 서브트리에도 trimBST를 적용
        root.right = self.trimBST(root.right, low, high)
        
        return root

'''
Runtime: 40 ms, faster than 97.38% of Python3 online submissions for Trim a Binary Search Tree.
Memory Usage: 18.3 MB, less than 30.13% of Python3 online submissions for Trim a Binary Search Tree.
'''