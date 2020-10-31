'''
104.
Maximum Depth of Binary Tree
https://leetcode.com/problems/maximum-depth-of-binary-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def DFS(self, node: TreeNode, depth: int) -> int:
        if not node:
            return depth - 1
        
        if not(node.left or node.right):
            return depth
        
        return max(self.DFS(node.left, depth + 1), self.DFS(node.right, depth + 1))
    
    def maxDepth(self, root: TreeNode) -> int:
        depth = 1
        
        if not root:
            return 0
        
        return max(self.DFS(root.left, depth + 1), self.DFS(root.right, depth + 1))

'''
Runtime: 40 ms, faster than 75.17% of Python3 online submissions for Maximum Depth of Binary Tree.
Memory Usage: 15.8 MB, less than 57.69% of Python3 online submissions for Maximum Depth of Binary Tree.
'''

'''
다른 사람의 풀이

class Solution:
    def maxDepth(self, node: TreeNode) -> int:
        if node is None:
            return 0

        return max(self.maxDepth(node.left) + 1, self.maxDepth(node.right) + 1)

단말 노드에서 반환되어오면서 반환값을 +1씩 하면 depth라는 변수를 따로 사용하지 않고도 풀 수 있는 문제였다.
좀 더 신중하게 생각할걸 그랬다..
'''