'''
392.
Is Subsequence
https://leetcode.com/problems/is-subsequence/
'''

class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if not s or not t:      # 만약 s = 'foo' and t = ''이면 False 반환, 나머지 경우는 True 반환
            return not s
        
        for x in t:
            if x == s[0]:      # s의 첫번째 문자가 발견될 때마다 소거시킴
                s = s[1:]
            
            if not s:           # 전부 소거되어 s가 공백이 되면 True 반환
                return True
        
        return False            # t를 전부 탐색해도 s가 남아있으면 False 반환

'''
Runtime: 28 ms, faster than 82.95% of Python3 online submissions for Is Subsequence.
Memory Usage: 14.5 MB, less than 13.33% of Python3 online submissions for Is Subsequence.
'''