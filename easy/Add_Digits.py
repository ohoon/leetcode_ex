'''
258.
Add Digits
https://leetcode.com/problems/add-digits/
'''

class Solution:
    def addDigits(self, num: int) -> int:
        while num > 9:
            temp = 0
            while num > 0:
                temp += num % 10
                num //= 10
            
            num = temp
            
        return num

'''
Runtime: 32 ms, faster than 58.86% of Python3 online submissions for Add Digits.
Memory Usage: 14.1 MB, less than 31.60% of Python3 online submissions for Add Digits.
'''

'''
다른 풀이

class Solution:
    def addDigits(self, num: int) -> int:
        if num == 0:
            return 0
        if num % 9 == 0:
            return 9
        return num % 9

digital root라고 하는 수학 공식을 사용하면 loop없이 풀이할 수 있다고 함
프로그래밍을 하는데 있어 수학적 지식이 많아야 하는지는 의문이지만, 이 공식을 알아둬서 나쁠게 없어보인다.

'''