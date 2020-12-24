'''
703.
Kth Largest Element in a Stream
https://leetcode.com/problems/kth-largest-element-in-a-stream/
'''

import heapq

class KthLargest:

    def __init__(self, k: int, nums: list(int)):
        self.k = k
        self.nums = []
        for n in nums:                      # nums의 요소를 하나씩 새롭게 heapify하는데, k 길이로 구성하여 k번째로 큰 수가 0번 인덱스에 오도록 함
            if len(self.nums) == self.k:
                if n < self.nums[0]:
                    continue
                    
                heapq.heappop(self.nums)
                
            heapq.heappush(self.nums, n)

    def add(self, val: int) -> int:
        if len(self.nums) == self.k:        # val이 nums의 최소값(=k번째로 큰 수)보다 크면 최소값을 pop하고 val을 push
            if val < self.nums[0]:
                return self.nums[0]

            heapq.heappop(self.nums)

        heapq.heappush(self.nums, val)
        
        return self.nums[0]                 # k번째로 큰 수

'''
Runtime: 96 ms, faster than 73.07% of Python3 online submissions for Kth Largest Element in a Stream.
Memory Usage: 18.3 MB, less than 35.26% of Python3 online submissions for Kth Largest Element in a Stream.
'''