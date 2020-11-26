'''
404.
Sum of Left Leaves
https://leetcode.com/problems/sum-of-left-leaves/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        s = self.sumOfLeftLeaves(root.left) + self.sumOfLeftLeaves(root.right)      # 서브 트리의 결과 취합
        leftNode = root.left
        if leftNode and not leftNode.left and not leftNode.right:       # 왼쪽 노드면서 단말 노드일 경우 val 값만큼 증가
            s += leftNode.val
        
        return s

'''
Runtime: 36 ms, faster than 27.45% of Python3 online submissions for Sum of Left Leaves.
Memory Usage: 15.1 MB, less than 9.71% of Python3 online submissions for Sum of Left Leaves.
'''