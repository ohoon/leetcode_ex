'''
409.
Longest Palindrome
https://leetcode.com/problems/longest-palindrome/
'''

from collections import Counter

class Solution:
    def longestPalindrome(self, s: str) -> int:
        counter = Counter(s)
        answer = 0
        hasOdd = False              # 한 번이라도 홀수가 나왔다면
        for x in counter.values():
            if x % 2 != 0:          # 홀수인 경우, 대칭이 되기 위해선 짝수개만큼만 더해줌
                hasOdd = True
                answer += x - 1
                continue
            
            answer += x             # 짝수인 경우
        
        if hasOdd:                  # 문자열의 가운데 인덱스에선 짝수일 필요가 없으므로 홀수에서 하나를 가져옴
            answer += 1
            
        return answer

'''
Runtime: 28 ms, faster than 86.50% of Python3 online submissions for Longest Palindrome.
Memory Usage: 14.1 MB, less than 56.46% of Python3 online submissions for Longest Palindrome.
'''