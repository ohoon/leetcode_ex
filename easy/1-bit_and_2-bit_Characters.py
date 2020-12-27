'''
717.
1-bit and 2-bit Characters
https://leetcode.com/problems/1-bit-and-2-bit-characters/
'''

from collections import deque

class Solution:
    def isOneBitCharacter(self, bits: list(int)) -> bool:
        bits = deque(bits)
        while len(bits) > 1:            # 마지막 character을 만날 때까지
            pop = bits.popleft()
            if pop == 1:                # 2-bits character의 경우 pop을 2번 수행
                bits.popleft()
        
        return bits                     # 마지막 character이 남아있으면 1-bit character

'''
Runtime: 48 ms, faster than 80.39% of Python3 online submissions for 1-bit and 2-bit Characters.
Memory Usage: 14.2 MB, less than 84.76% of Python3 online submissions for 1-bit and 2-bit Characters.
'''

'''
다른 풀이
class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        parity = bits.pop()
        while bits and bits.pop(): parity ^= 1
        return parity == 0

0이 나온다면 10이든 0이든 character이 끝나므로
뒤에서 2번째로 나온 0과 맨 끝의 0 사이에 1이 짝수개가 있다면 ..0, 11, 11, 11, ..., 0와 같이 1-bit로 끝나는 것이다.
반대로 홀수개라면 ..0, 11, 11, ..., 10처럼 2-bit로 끝나는 것임을 알 수 있다.

'''