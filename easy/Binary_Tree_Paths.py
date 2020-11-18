'''
257.
Binary Tree Paths
https://leetcode.com/problems/binary-tree-paths/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def printTreePath(self, node, prevPath, result):
        if not node.left and not node.right:        # leaf노드면 현재 노드값까지의 경로를 result에 append하고 종료
            return result.append(prevPath + str(node.val))
        
        if node.left:
            self.printTreePath(node.left, prevPath + str(node.val) + '->', result)      # 경로값을 누적시키고 왼쪽 가지로 탐색
        
        if node.right:
            self.printTreePath(node.right, prevPath + str(node.val) + '->', result)     # 경로값을 누적시키고 오른쪽 가지로 탐색
        
        return
            
    def binaryTreePaths(self, root: TreeNode) -> list(str):
        if not root:
            return []
        
        result = []
        self.printTreePath(root, "", result)
        
        return result

'''
Runtime: 32 ms, faster than 64.77% of Python3 online submissions for Binary Tree Paths.
Memory Usage: 14.2 MB, less than 5.99% of Python3 online submissions for Binary Tree Paths.
'''