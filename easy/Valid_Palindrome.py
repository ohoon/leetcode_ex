'''
125.
Valid Palindrome
https://leetcode.com/problems/valid-palindrome/
'''

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = "".join(list(filter(lambda x: x.isalpha() or x.isdigit(), s.lower())))      # 알파벳과 숫자만 추출
        return s == s[::-1]     # 좌우대칭이면 True 아니면 False

'''
Runtime: 36 ms, faster than 95.36% of Python3 online submissions for Valid Palindrome.
Memory Usage: 14.8 MB, less than 10.61% of Python3 online submissions for Valid Palindrome.
'''