'''
414.
Third Maximum Number
https://leetcode.com/problems/third-maximum-number/
'''

class Solution:
    def thirdMax(self, nums: list(int)) -> int:
        nums = list(set(nums))
        length = len(nums)
        if length < 3:
            return max(nums)
        
        for i in range(length + 1):
            if i == length or nums[i] < 0:          # 음수가 발견되지 않으면 뒤에서 3번째 원소를, 발견된다면 양수 중 뒤에서 3번째 원소를 반환
                return nums[i-3]                    # 이 때, [3, 6, -5, -2, -1]처럼 양수의 개수가 3미만이라면 nums[i-3] = nums[2-3] = nums[-1] = -1이다.
                                                    # 즉 6, 3을 구하고 양수가 없으면 뒤에서부터 탐색을 이어가기 때문에 음수의 최대값 순서로 계속 탐색이 가능함

'''
Runtime: 44 ms, faster than 94.77% of Python3 online submissions for Third Maximum Number.
Memory Usage: 15.8 MB, less than 5.17% of Python3 online submissions for Third Maximum Number.
'''

'''
다른 풀이

import heapq

class Solution:
    def thirdMax(self, nums: list(int)) -> int:
        nums = set(nums)
        heap = []
        if len(nums) < 3:
            return max(nums)
        
        for n in nums:
            heapq.heappush(heap, -n)        # 최소힙을 최대힙처럼 사용하기 위해 임시로 -를 곱해 삽입해줌
            
        for _ in range(2):
            heapq.heappop(heap)
        
        return -heapq.heappop(heap)         # 3번째로 작은 값 = -(3번째로 큰 값)

O(N)을 만족하기 위해서 머리를 굴려본 결과, heap sort를 이용하면 시간복잡도는 O(N*logN)이지만 실질적인 시간은 O(N)과 가깝기 때문에 좋은 풀이라고 생각했다.
하지만 set를 이용하면 더 빠르게 구할 수 있다는 것을 다른 사람들의 힌트로 깨닫고 다시 풀이를 했다.
set로 취해도 음수가 배열 뒤로 가는 문제때문에 쉽진 않았지만 성공적으로 풀이해냈다.

'''