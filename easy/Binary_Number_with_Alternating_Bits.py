'''
693.
Binary Number with Alternating Bits
https://leetcode.com/problems/binary-number-with-alternating-bits/
'''

class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        next_bit = n % 2
        while n > 0:
            if n % 2 != next_bit:           # 같은 비트가 연속해서 나오면 False 반환
                return False
            
            n //= 2
            next_bit = abs(next_bit - 1)    # 다음 비트는 현재 비트의 반대 (0 -> 1, 1 -> 0)
        
        return True

'''
Runtime: 36 ms, faster than 86.03% of Python3 online submissions for Baseball Game.
Memory Usage: 14.3 MB, less than 86.84% of Python3 online submissions for Baseball Game.
'''

'''
다른 풀이

class Solution(object):
    def hasAlternatingBits(self, n):
        n, cur = divmod(n, 2)
        while n:
            if cur == n % 2: return False
            n, cur = divmod(n, 2)
        return True

다음 bit를 abs(next_bit - 1)로 계산해서 예측하는 것 대신에 나누기를 먼저해서 나머지 값을 비교하는 방법을 사용한 풀이다.

'''