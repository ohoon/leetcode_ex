'''
459.
Repeated Substring Pattern
https://leetcode.com/problems/repeated-substring-pattern/
'''

class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        length = len(s)
        for i in range(1, (length // 2) + 1):       # substring의 최대 길이는 s의 절반
            if length % i != 0:
                continue
                
            if s == s[:i] * (length // i):          # substring의 반복이 s와 같으면 True
                return True
        
        return False

'''
Runtime: 44 ms, faster than 67.76% of Python3 online submissions for Repeated Substring Pattern.
Memory Usage: 14.3 MB, less than 62.40% of Python3 online submissions for Repeated Substring Pattern.
'''

'''
다른 사람의 풀이

class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        
        s_fold = s[1:] + s[:-1]
        
        return s in s_fold

s가 substring으로 이루어진 문자열이라면
s의 각 양 끝의 문자를 제외시킨 두 substring의 합은 s를 무조건 포함한다는 규칙을 이용한 풀이다.
이 규칙을 이용하면 loop를 거치지 않아도 되기 때문에 훨씬 효율적인 것 같다.

'''