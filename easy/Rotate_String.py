'''
796.
Rotate String
https://leetcode.com/problems/rotate-string/
'''

class Solution:
    def rotateString(self, A: str, B: str) -> bool:
        return len(A) == len(B) and A in (B * 2)

'''
Runtime: 24 ms, faster than 93.97% of Python3 online submissions for Rotate String.
Memory Usage: 14.3 MB, less than 10.79% of Python3 online submissions for Rotate String.
'''