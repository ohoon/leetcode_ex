'''
938.
Range Sum of BST
https://leetcode.com/problems/range-sum-of-bst/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        if not root:
            return 0
        
        if root.val < low:          # 노드 값이 low보다 작으면 우측 서브트리 합산 값만 반환
            return self.rangeSumBST(root.right, low, high)
        
        if root.val > high:         # 노드 값이 high보다 크면 좌측 서브트리 합산 값만 반환
            return self.rangeSumBST(root.left, low, high)
                                    # 노드 값이 범주 안에 들어가면 자신의 노드 값과 좌우 서브트리 합산 값을 더하여 반환
        return self.rangeSumBST(root.left, low, high) + root.val + self.rangeSumBST(root.right, low, high)

'''
Runtime: 188 ms, faster than 98.85% of Python3 online submissions for Range Sum of BST.
Memory Usage: 22.3 MB, less than 20.22% of Python3 online submissions for Range Sum of BST.
'''

'''
여담

재귀적으로 풀이할 땐 최대한 복잡하게 생각하지말고 간단하게 생각하는 것이 나은 것 같다.
모듈식으로 생각을 하니 금새 풀이법이 도출되더라

'''