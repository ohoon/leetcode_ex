'''
594.
Longest Harmonious Subsequence
https://leetcode.com/problems/longest-harmonious-subsequence/
'''

from collections import Counter

class Solution:
    def findLHS(self, nums: list(int)) -> int:
        counter = Counter(nums)
        maximum = 0
        for x in counter.keys():
            if (x + 1) in counter:      # 자기 자신의 +1인 수가 존재하면
                maximum = max(maximum, counter[x] + counter[x+1])       # 최대 길이와 두 수의 갯수 합 비교
        
        return maximum

'''
Runtime: 288 ms, faster than 86.97% of Python3 online submissions for Longest Harmonious Subsequence.
Memory Usage: 16 MB, less than 18.86% of Python3 online submissions for Longest Harmonious Subsequence.
'''