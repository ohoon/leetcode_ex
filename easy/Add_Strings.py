'''
415.
Add Strings
https://leetcode.com/problems/add-strings/
'''

class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        max_length = max(len(num1), len(num2))
        num1, num2 = num1.zfill(max_length), num2.zfill(max_length)         # 글자수를 맞추기 위함
        answer = ''
        carry = 0
        for i in range(max_length - 1, -1, -1):
            res = int(num1[i]) + int(num2[i]) + carry                       # 각 자리수의 합 + 올림수
            answer = str(res % 10) + answer
            carry = res // 10
        
        if carry > 0:
            answer = str(carry) + answer                                    # 남은 올림수 처리
        
        return answer

'''
Runtime: 40 ms, faster than 70.08% of Python3 online submissions for Add Strings.
Memory Usage: 14.3 MB, less than 44.32% of Python3 online submissions for Add Strings.
'''