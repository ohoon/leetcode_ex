'''
700.
Search in a Binary Search Tree
https://leetcode.com/problems/search-in-a-binary-search-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def searchBST(self, root: TreeNode, val: int) -> TreeNode:
        if not root:
            return None
        
        if root.val > val:                          # 노드 값보다 val이 작으므로 왼쪽 서브트리로 전개
            return self.searchBST(root.left, val)
        
        if root.val < val:                          # 노드 값보다 val이 크므로 오른쪽 서브트리로 전개
            return self.searchBST(root.right, val)
        
        return root                                 # val값을 찾았으면 해당 노드 반환

'''
Runtime: 68 ms, faster than 88.89% of Python3 online submissions for Search in a Binary Search Tree.
Memory Usage: 15.9 MB, less than 87.70% of Python3 online submissions for Search in a Binary Search Tree.
'''