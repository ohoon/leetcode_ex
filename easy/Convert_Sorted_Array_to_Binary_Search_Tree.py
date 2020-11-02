'''
108.
Convert Sorted Array to Binary Search Tree
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sortedArrayToBST(self, nums: list(int)) -> TreeNode:
        if not nums:            # 트리에 삽입할 숫자가 없으면 None 반환
            return None
        
        center = len(nums) // 2     # 서브트리의 루트 역할을 할 숫자의 인덱스
        node = TreeNode(
            val=nums[center], 
            left=self.sortedArrayToBST(nums[:center]), 
            right=self.sortedArrayToBST(nums[center+1:])
        )
        
        return node

'''
Runtime: 68 ms, faster than 86.98% of Python3 online submissions for Convert Sorted Array to Binary Search Tree.
Memory Usage: 16.3 MB, less than 100.00% of Python3 online submissions for Convert Sorted Array to Binary Search Tree.
'''

'''
여담

점점 재귀법에 익숙해진 듯 하다.
문제가 쉽긴 하지만 그래도 20분 안에 풀었으니 빨리 풀었다고 생각함

'''