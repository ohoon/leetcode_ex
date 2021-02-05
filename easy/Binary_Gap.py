'''
868.
Binary Gap
https://leetcode.com/problems/binary-gap/
'''

class Solution:
    def binaryGap(self, n: int) -> int:
        between = bin(n)[2:].split('1')[1:-1]       # 1 사이의 0의 개수들을 모은 리스트
        
        if not between:                             # 1이 한 개거나 아예 없을 경우
            return 0
        
        return len(max(between)) + 1                # 최대 개수를 구해 반환

'''
Runtime: 32 ms, faster than 63.37% of Python3 online submissions for Binary Gap.
Memory Usage: 14.3 MB, less than 46.68% of Python3 online submissions for Binary Gap.
'''

'''
다른 풀이

class Solution(object):
    def binaryGap(self, N):
        last = None
        ans = 0
        for i in xrange(32):
            if (N >> i) & 1:
                if last is not None:
                    ans = max(ans, i - last)
                last = i
        return ans

비트 연산자를 이용해서 1 사이의 최대 거리를 찾는 방식이다.

'''