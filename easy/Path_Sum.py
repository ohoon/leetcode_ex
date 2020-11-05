'''
112.
Path Sum
https://leetcode.com/problems/path-sum/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if not root:
            return False
            
        sum -= root.val
        if not(root.left or root.right):        # 단말 노드일 때
            return sum == 0
        
        return self.hasPathSum(root.left, sum) or self.hasPathSum(root.right, sum)

'''
Runtime: 40 ms, faster than 83.54% of Python3 online submissions for Path Sum.
Memory Usage: 15.8 MB, less than 93.96% of Python3 online submissions for Path Sum.
'''