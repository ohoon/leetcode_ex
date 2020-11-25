'''
389.
Find the Difference
https://leetcode.com/problems/find-the-difference/
'''

class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        answer = 0
        for i in range(len(s)):
            answer += ord(t[i]) - ord(s[i])
        
        answer += ord(t[-1])
        
        return chr(answer)      # t의 ascii값의 합 - s의 ascii값의 합 = t에 추가된 문자의 ascii값

'''
Runtime: 24 ms, faster than 97.46% of Python3 online submissions for Find the Difference.
Memory Usage: 14.2 MB, less than 63.03% of Python3 online submissions for Find the Difference.
'''