'''
66.
Plus One
https://leetcode.com/problems/plus-one/
'''

class Solution:
    def plusOne(self, digits: list(int)) -> list(int):
        cursor = len(digits) - 1
        
        while cursor >= 0:
            if digits[cursor] < 9:      # 올림수가 없을 때
                digits[cursor] += 1
                return digits
                
            digits[cursor] = 0      # 올림수가 발생할 때, 다음 자리 수로 이동
            cursor -= 1
            
        return [1] + digits     # 999+1처럼 올림수로 인해서 자리수가 증가할 때
        

'''
Runtime: 32 ms, faster than 65.83% of Python3 online submissions for Plus One.
Memory Usage: 14.2 MB, less than 99.97% of Python3 online submissions for Plus One.
'''