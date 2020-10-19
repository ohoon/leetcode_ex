'''
35.
Search Insert Position
https://leetcode.com/problems/implement-strstr/
'''

class Solution:
    def searchInsert(self, nums: list(int), target: int) -> int:
        for i, x in enumerate(nums):
            if x >= target:
                return i
            
        return i + 1
        

'''
Runtime: 44 ms, faster than 91.36% of Python3 online submissions for Search Insert Position.
Memory Usage: 14.5 MB, less than 72.58% of Python3 online submissions for Search Insert Position.
'''