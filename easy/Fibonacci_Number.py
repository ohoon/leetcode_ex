'''
509.
Fibonacci Number
https://leetcode.com/problems/fibonacci-number/
'''

class Solution:
    def fib(self, N: int) -> int:
        if N <= 1:
            return N
        
        current = 0
        prev1 = 1
        prev2 = 0
        for _ in range(2, N + 1):
            current = prev1 + prev2
            prev2 = prev1
            prev1 = current
        
        return current

'''
Runtime: 28 ms, faster than 77.46% of Python3 online submissions for Fibonacci Number.
Memory Usage: 14.1 MB, less than 77.01% of Python3 online submissions for Fibonacci Number.
'''