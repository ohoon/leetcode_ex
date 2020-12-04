'''
504.
Base 7
https://leetcode.com/problems/base-7/
'''

class Solution:
    def convertToBase7(self, num: int) -> str:
        if num == 0:
            return "0"
        
        answer = ''
        minus = True if num < 0 else False      # 음수면 마지막 결과값에 '-'을 붙여줌
        num = abs(num)                          # 양수 기준으로 연산
        while num != 0:
            answer = str(num % 7) + answer
            num //= 7
            
        return ('-' + answer) if minus else answer

'''
Runtime: 24 ms, faster than 95.18% of Python3 online submissions for Base 7.
Memory Usage: 14 MB, less than 95.18% of Python3 online submissions for Base 7.
'''