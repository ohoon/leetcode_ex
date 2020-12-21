'''
674.
Longest Continuous Increasing Subsequence
https://leetcode.com/problems/longest-continuous-increasing-subsequence/
'''

class Solution:
    def findLengthOfLCIS(self, nums: list(int)) -> int:
        maximum = 0
        count = 1
        length = len(nums)
        if length < 2:
            return length
        
        for i in range(1, length):
            if nums[i] > nums[i-1]:         # increasing하면
                count += 1
            else:
                count = 1                   # 아니면 1로 초기화
            
            if count > maximum:             # 최대 개수 갱신
                maximum = count
        
        return maximum

'''
Runtime: 72 ms, faster than 78.78% of Python3 online submissions for Longest Continuous Increasing Subsequence.
Memory Usage: 15.4 MB, less than 11.23% of Python3 online submissions for Longest Continuous Increasing Subsequence.
'''