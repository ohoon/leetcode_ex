'''
563.
Binary Tree Tilt
https://leetcode.com/problems/binary-tree-tilt/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def findTilt(self, root: TreeNode) -> int:
        total = 0
        def DFS(root: TreeNode) -> int:
            if not root:
                return 0
            
            nonlocal total
            left_side = DFS(root.left)                  # 왼쪽 서브트리의 모든 val의 합을 가져옴
            right_side = DFS(root.right)                # 오른쪽 서브트리의 모든 val의 합을 가져옴
            total += abs(left_side - right_side)        # tilt를 구하여 total에 더함
            
            return left_side + root.val + right_side    # 재귀법을 위해 자신과 서브트리의 모든 val의 합을 반환
        
        DFS(root)
        
        return total

'''
Runtime: 48 ms, faster than 95.66% of Python3 online submissions for Binary Tree Tilt.
Memory Usage: 16.4 MB, less than 6.05% of Python3 online submissions for Binary Tree Tilt.
'''