'''
1480.
Running Sum of 1d Array
https://leetcode.com/problems/running-sum-of-1d-array/
'''

class Solution:
    def runningSum(self, nums: list(int)) -> list(int):
        return [sum(nums[:i+1]) for i in range(len(nums))]

'''
Runtime: 56 ms, faster than 21.51% of Python3 online submissions for Running Sum of 1d Array.
Memory Usage: 14.5 MB, less than 99.99% of Python3 online submissions for Running Sum of 1d Array.
'''

'''
다른 사람의 풀이

class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        for i in range(1, len(nums)):
            nums[i] = nums[i] + nums[i - 1]
        return nums

i마다 sum을 반복하면 O(N*N)인 반면에
i=1부터 시작하여 바로 전의 값을 현재 값에 더해주면서 i=len(nums)-1까지 탐색하면 저절로 running sum 배열이 완성된다. 이때 시간복잡도는 대략 O(N)이다.
좀 더 시간복잡도를 생각해서 답안을 제출하는 습관을 기르자.
'''