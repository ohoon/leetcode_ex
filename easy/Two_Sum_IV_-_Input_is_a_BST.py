'''
653.
Two Sum IV - Input is a BST
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def findTarget(self, root: TreeNode, k: int) -> bool:
        hash_map = {}
        def traversal(root: TreeNode, k) -> bool:
            if not root:
                return False
            
            nonlocal hash_map
            if (k - root.val) in hash_map:              # 두 노드의 합이 k가 될 수 있다면
                return True
            
            hash_map[root.val] = root
            
            return traversal(root.left, k) or traversal(root.right, k)          # 좌, 우측 노드로 탐색
        
        return traversal(root, k)

'''
Runtime: 820 ms, faster than 69.19% of Python3 online submissions for Maximum Average Subarray I.
Memory Usage: 18.1 MB, less than 5.25% of Python3 online submissions for Maximum Average Subarray I.
'''