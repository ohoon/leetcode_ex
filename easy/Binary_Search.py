'''
704.
Binary Search
https://leetcode.com/problems/binary-search/
'''

class Solution:
    def search(self, nums: list(int), target: int) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            cur = (left + right) // 2
            if nums[cur] > target:
                right = cur
                continue
            
            if nums[cur] < target:
                left = cur + 1
                continue
            
            return cur
        
        return left if nums[left] == target else -1

'''
Runtime: 236 ms, faster than 59.16% of Python3 online submissions for Binary Search.
Memory Usage: 15.6 MB, less than 19.88% of Python3 online submissions for Binary Search.
'''