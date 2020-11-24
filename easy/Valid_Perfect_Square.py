'''
367.
Valid Perfect Square
https://leetcode.com/problems/valid-perfect-square/
'''

class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        if num == 1:
            return True
        
        left, right = 0, num
        while left < right:                 # binary-search
            mid = (left + right) // 2
            if num > mid ** 2:
                left = mid + 1
                continue
            
            if num < mid ** 2:
                right = mid
                continue
            
            return True
            
        return False

'''
Runtime: 24 ms, faster than 91.89% of Python3 online submissions for Valid Perfect Square.
Memory Usage: 14.2 MB, less than 6.54% of Python3 online submissions for Valid Perfect Square.
'''