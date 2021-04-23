'''
1485.
XOR Operation in an Array
https://leetcode.com/problems/xor-operation-in-an-array/
'''

class Solution:
    def xorOperation(self, n: int, start: int) -> int:
        answer = 0
        for i in range(n):
            answer ^= start + 2*i       # bit연산 XOR

        return answer

'''
Runtime: 32 ms, faster than 54.58% of Python3 online submissions for XOR Operation in an Array.
Memory Usage: 14.2 MB, less than 78.84% of Python3 online submissions for XOR Operation in an Array.
'''