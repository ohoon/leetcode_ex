'''
434.
Number of Segments in a String
https://leetcode.com/problems/number-of-segments-in-a-string/
'''

class Solution:
    def countSegments(self, s: str) -> int:
        return len(s.split())

'''
Runtime: 28 ms, faster than 67.34% of Python3 online submissions for Number of Segments in a String.
Memory Usage: 14.1 MB, less than 30.04% of Python3 online submissions for Number of Segments in a String.
'''