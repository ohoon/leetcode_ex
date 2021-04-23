'''
1523.
Count Odd Numbers in an Interval Range
https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
'''

class Solution:
    def countOdds(self, low: int, high: int) -> int:
        diff = high - low
        if diff % 2 == 0:                   # diff가 짝수개면
            return diff // 2 + high % 2     # (홀, 짝, ..., 홀, 짝, high)

        return (diff - 1) // 2 + low % 2 + high % 2     # diff가 홀수면 (low, 홀, 짝, ..., 홀, 짝, high)

'''
Runtime: 32 ms, faster than 46.46% of Python3 online submissions for Count Odd Numbers in an Interval Range.
Memory Usage: 14.2 MB, less than 72.52% of Python3 online submissions for Count Odd Numbers in an Interval Range.
'''