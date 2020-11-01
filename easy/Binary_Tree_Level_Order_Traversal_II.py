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
    def levelOrderBottom(self, root: TreeNode) -> list(list(int)):
        node = [root]
        traverse = []
        
        while node:
            next_node = []      # 다음 레벨의 노드 목록
            node_value = []     # 현재 레벨의 노드 값 목록
            for n in node:
                if not n:
                    continue
                    
                next_node += [n.left, n.right]
                node_value.append(n.val)
            
            node = next_node
            if node_value:
                traverse.append(node_value)
        
        return traverse[::-1]       # bottom-up이기 때문에 reverse

'''
Runtime: 28 ms, faster than 95.06% of Python3 online submissions for Binary Tree Level Order Traversal II.
Memory Usage: 14.3 MB, less than 20.36% of Python3 online submissions for Binary Tree Level Order Traversal II.
'''