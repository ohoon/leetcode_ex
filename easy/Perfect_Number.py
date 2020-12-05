'''
507.
Perfect Number
https://leetcode.com/problems/perfect-number/
'''

class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        if num <= 1:
            return False
        
        res = 1
        for i in range(int(num ** 0.5), 1, -1):
            if num % i == 0:
                res += i + (num // i) if i ** 2 != num else 0
                if res > num:
                    return False
        
        if res < num:
            return False
        
        return True

'''
Runtime: 40 ms, faster than 48.57% of Python3 online submissions for Perfect Number.
Memory Usage: 14.3 MB, less than 15.83% of Python3 online submissions for Perfect Number.
'''