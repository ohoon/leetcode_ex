'''
709.
To Lower Case
https://leetcode.com/problems/to-lower-case/
'''

class Solution:
    def toLowerCase(self, str: str) -> str:
        answer = ''
        for s in str:
            if 64 < ord(s) < 91:                # 대문자일 경우 아스키코드에 32를 더하여 소문자로 치환
                answer += chr(ord(s) + 32)
            else:
                answer += s
        
        return answer

'''
Runtime: 28 ms, faster than 73.60% of Python3 online submissions for To Lower Case.
Memory Usage: 14.3 MB, less than 24.90% of Python3 online submissions for To Lower Case.
'''