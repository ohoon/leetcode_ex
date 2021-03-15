'''
1018.
Binary Prefix Divisible By 5
https://leetcode.com/problems/binary-prefix-divisible-by-5/
'''

class Solution:
    def prefixesDivBy5(self, A: list(int)) -> list(bool):
        answer = []
        num = 0
        for a in A:
            num = 2 * num + a           # 기존 num을 왼쪽 시프트하고 a 증가
            answer.append(num % 5 == 0)
        
        return answer

'''
Runtime: 312 ms, faster than 60.34% of Python3 online submissions for Binary Prefix Divisible By 5.
Memory Usage: 15.2 MB, less than 81.32% of Python3 online submissions for Binary Prefix Divisible By 5.
'''
