'''
543.
Diameter of Binary Tree
https://leetcode.com/problems/diameter-of-binary-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    max_length = 0          # 최대 path 길이
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.lengthOfBinaryTree(root)
        
        return self.max_length
    
    def lengthOfBinaryTree(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        left_side = self.lengthOfBinaryTree(root.left)          # 좌측 서브트리의 최대 깊이 길이
        right_side = self.lengthOfBinaryTree(root.right)        # 우측 서브트리의 최대 깊이 길이
        self.max_length = max(left_side + right_side, self.max_length)      # 좌, 우측 서브트리 길이의 합이 최대값이면 갱신
        
        return max(left_side, right_side) + 1           # 좌, 우측 서브트리 중 더 깊은 것을 선택, 깊이를 한 단계 증가해서 반환

'''
Runtime: 44 ms, faster than 66.15% of Python3 online submissions for Diameter of Binary Tree.
Memory Usage: 16 MB, less than 78.00% of Python3 online submissions for Diameter of Binary Tree.
'''

'''
여담

문제를 이해하는데 조금 어려움을 겪었지만 머리속으로 여러가지 경우의 수를 생각해보고 시뮬레이션해보니 감이 좀 잡혔다.
트리 구조에 대해서 곰곰히 생각해보는 좋은 문제라고 생각한다.

'''