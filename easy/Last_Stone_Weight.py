'''
1046.
Last Stone Weight
https://leetcode.com/problems/last-stone-weight/
'''

from heapq import heappush, heappop

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = []
        for s in stones:
            heappush(heap, [-s, s])     # max-heap
        
        while len(heap) > 1:
            first = heappop(heap)[1]
            second = heappop(heap)[1]
            result = first - second
            if result > 0:              # first와 second가 같으면 heappush 생략
                heappush(heap, [-result, result])
        
        return heappop(heap)[1] if len(heap) != 0 else 0

'''
Runtime: 32 ms, faster than 66.58% of Python3 online submissions for Last Stone Weight.
Memory Usage: 14.2 MB, less than 79.84% of Python3 online submissions for Last Stone Weight.
'''
