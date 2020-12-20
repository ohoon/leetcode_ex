'''
671.
Second Minimum Node In a Binary Tree
https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def findSecondMinimumValue(self, root: TreeNode) -> int:
        answer = float("inf")
        minimum = root.val
        def dfs(root: TreeNode):
            if not root:
                return
            
            nonlocal answer, minimum
            if minimum < root.val < answer:     # 2번째로 작은 수 갱신
                answer = root.val
            
            dfs(root.left)                      # 깊이 우선 탐색
            dfs(root.right)
        
        dfs(root)
        
        return answer if answer != float("inf") else -1

'''
Runtime: 28 ms, faster than 79.46% of Python3 online submissions for Second Minimum Node In a Binary Tree.
Memory Usage: 14.2 MB, less than 48.30% of Python3 online submissions for Second Minimum Node In a Binary Tree.
'''