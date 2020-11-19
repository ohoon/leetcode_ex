'''
268.
Missing Number
https://leetcode.com/problems/missing-number/
'''

class Solution:
    def missingNumber(self, nums: list(int)) -> int:
        n = len(nums)
        total = n * (n + 1) // 2        # 0부터 n까지의 합 공식
        
        return total - sum(nums)        # 0 ~ n까지의 합 - 주어진 nums 합 = 누락된 숫자

'''
Runtime: 120 ms, faster than 92.63% of Python3 online submissions for Missing Number.
Memory Usage: 15 MB, less than 91.22% of Python3 online submissions for Missing Number.
'''