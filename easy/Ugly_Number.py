'''
263.
Ugly Number
https://leetcode.com/problems/ugly-number/
'''

class Solution:
    def isUgly(self, num: int) -> bool:
        while num > 1:          # 2, 3, 5로 나눌 수 있는만큼 나누고, 그 결과가 1이 아니면 다른 prime 수를 소인수로 갖는 숫자라고 추정
            if num % 2 == 0:
                num /= 2
                continue
            
            if num % 3 == 0:
                num /= 3
                continue
            
            if num % 5 == 0:
                num /= 5
                continue
            
            return False
                
        return num == 1

'''
Runtime: 24 ms, faster than 94.21% of Python3 online submissions for Ugly Number.
Memory Usage: 14.1 MB, less than 74.49% of Python3 online submissions for Ugly Number.
'''