'''
1005.
Maximize Sum Of Array After K Negations
https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
'''

from heapq import heappush, heappop

class Solution:
    def largestSumAfterKNegations(self, A: list(int), K: int) -> int:
        heap = []
        for x in A:					# min-heap 트리 구축
            heappush(heap, x)
            
        for _ in range(K):			# 최소값을 heappop하여 -1을 곱해주고 다시 heappush하여 트리를 갱신. K만큼 반복
            popped = heappop(heap)
            popped *= -1
            heappush(heap, popped)
        
        return sum(heap)			# 결과 heap 트리 노드들의 합을 반환

'''
Runtime: 48 ms, faster than 70.38% of Python3 online submissions for Maximize Sum Of Array After K Negations.
Memory Usage: 14.4 MB, less than 62.52% of Python3 online submissions for Maximize Sum Of Array After K Negations.
'''

'''
다른 사람의 풀이

from heapq import heapify, heapreplace

class Solution:
    def largestSumAfterKNegations(self, nums: List[int], k: int) -> int:
        heapify(nums)
        while k and nums[0] < 0:
            heapreplace(nums, -nums[0])
            k -= 1
        if k % 2:
            heapreplace(nums, -nums[0])
        return sum(nums)

heappush, heappop하는 방법 외에도 heapify를 사용하여 한번에 min-heap 트리를 만들고 heapreplace로 각 노드를 업데이트할 수 있음을 볼 수 있다.

'''
