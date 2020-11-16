'''
226.
Invert Binary Tree
https://leetcode.com/problems/invert-binary-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return
        
        root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)     # 재귀적으로 접근하여 left, right를 swap
        
        return root

'''
Runtime: 28 ms, faster than 80.27% of Python3 online submissions for Invert Binary Tree.
Memory Usage: 14.1 MB, less than 62.88% of Python3 online submissions for Invert Binary Tree.
'''

'''
다른 사람의 풀이

from collections import deque    
    
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:        
        
        traversal_queue = deque([root]) if root else None
        
		# lanuch BFS, aka level-order-traversal to carry out invertion
        while traversal_queue:
            
            cur_node = traversal_queue.popleft()
            
			# Invert child node of current node
            cur_node.left, cur_node.right = cur_node.right, cur_node.left
            
			# push left child into queue to invert left subtree
            if cur_node.left:
                traversal_queue.append( cur_node.left )
            
			# push right child into queue to invert right subtree
            if cur_node.right:
                traversal_queue.append( cur_node.right )                
        
        return root

나는 재귀법으로 푼 반면에, 이 사람의 코드는 반복법으로 풀이한 것이다.
확실히 재귀법으로 푸는 게 코드가 깔끔해지고 이해하기 쉬운 것 같다.

'''