'''
606.
Construct String from Binary Tree
https://leetcode.com/problems/construct-string-from-binary-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def tree2str(self, t: TreeNode) -> str:
        if not t:
            return ''
        
        string = str(t.val)
        left_side = self.tree2str(t.left)
        right_side = self.tree2str(t.right)
        if left_side or right_side:
            string += '(' + left_side + ')'
        
        if right_side:
            string += '(' + right_side + ')'
            
        return string

'''
Runtime: 48 ms, faster than 73.36% of Python3 online submissions for Construct String from Binary Tree.
Memory Usage: 16.1 MB, less than 41.10% of Python3 online submissions for Construct String from Binary Tree.
'''