'''
345.
Reverse Vowels of a String
https://leetcode.com/problems/reverse-vowels-of-a-string/
'''

class Solution:
    def reverseVowels(self, s: str) -> str:
        s = list(s)
        left, right = 0, len(s) - 1
        vowels = {'a': True, 'e': True, 'i': True, 'o': True, 'u': True,        # 모음 사전
                 'A': True, 'E': True, 'I': True, 'O': True, 'U': True}
        while left < right:
            if s[left] not in vowels:           # 왼쪽에서부터 모음 탐색
                left += 1
                continue
            
            if s[right] not in vowels:          # 오른쪽에서부터 모음 탐색
                right -= 1
                continue
            
            s[left], s[right] = s[right], s[left]       # swap
            left += 1
            right -= 1
        
        return "".join(s)

'''
Runtime: 52 ms, faster than 66.81% of Python3 online submissions for Reverse Vowels of a String.
Memory Usage: 15 MB, less than 50.23% of Python3 online submissions for Reverse Vowels of a String.
'''