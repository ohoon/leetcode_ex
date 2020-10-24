'''
67.
Add Binary
https://leetcode.com/problems/add-binary/
'''

class Solution:
    def addBinary(self, a: str, b: str) -> str:
        return bin(int(a, 2) + int(b, 2))[2:]

'''
Runtime: 20 ms, faster than 99.49% of Python3 online submissions for Add Binary.
Memory Usage: 14.1 MB, less than 99.99% of Python3 online submissions for Add Binary.
'''

'''
다른 풀이

class Solution:
    def addBinary(self, a: str, b: str) -> str:
        a = eval("0b" + a)
        b = eval("0b" + b)
        
        return bin(a + b)[2:]

int를 사용하지않고 eval을 이용해서 a, b를 10진수로 바꿨음

'''