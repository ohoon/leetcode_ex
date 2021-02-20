'''
917.
Reverse Only Letters
https://leetcode.com/problems/reverse-only-letters/
'''

class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        S = list(S)
        left, right = 0, len(S) - 1
        
        while left < right:
            if not S[left].isalpha():               # left 포인터와 right 포인터 둘 다 영문자를 가리키고 있을 때에만 swap하기 위함
                left = left + 1
                continue
                
            if not S[right].isalpha():
                right = right - 1
                continue
                
            S[left], S[right] = S[right], S[left]   # swap
            left, right = left + 1, right - 1
        
        return "".join(S)

'''
Runtime: 32 ms, faster than 63.07% of Python3 online submissions for Reverse Only Letters.
Memory Usage: 14.3 MB, less than 51.89% of Python3 online submissions for Reverse Only Letters.
'''