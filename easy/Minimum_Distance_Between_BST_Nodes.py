'''
783.
Minimum Distance Between BST Nodes
https://leetcode.com/problems/jewels-and-stones/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def minDiffInBST(self, root: TreeNode) -> int:
        if not root or (not root.left and not root.right):
            return float("inf")
        
        left_diff, right_diff = float("inf"), float("inf")          # 양측 서브트리의 차이값
        if root.left:                                               # 좌측 서브트리에서 가장 큰 값을 구해서 현재 노드와의 차이값을 계산
            node = root.left
            while node.right:
                node = node.right
                
            left_diff = abs(root.val - node.val)
        
        if root.right:                                              # 우측 서브트리에서 가장 작은 값을 구해서 현재 노드와의 차이값을 계산
            node = root.right
            while node.left:
                node = node.left
                
            right_diff = abs(root.val - node.val)
        
        return min(self.minDiffInBST(root.left), self.minDiffInBST(root.right), left_diff, right_diff)      # 양측 서브트리의 차이값과 밑에서부터 재귀하여 구해온 최소 차이값과 비교해서 최소값 반환

'''
Runtime: 24 ms, faster than 95.47% of Python3 online submissions for Minimum Distance Between BST Nodes.
Memory Usage: 14.5 MB, less than 8.62% of Python3 online submissions for Minimum Distance Between BST Nodes.
'''