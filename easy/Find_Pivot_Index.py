'''
724.
Find Pivot Index
https://leetcode.com/problems/find-pivot-index/
'''

class Solution:
    def pivotIndex(self, nums: list(int)) -> int:
        left = 0
        for i in range(len(nums)):              # dynamic programming, 현재 인덱스까지의 요소 합을 대입
            nums[i] += left
            left = nums[i]
            
        for i in range(len(nums)):
            right = nums[-1] - nums[i]                                      # 현재 인덱스 뒤까지의 합
            if (i == 0 and right == 0) or (i > 0 and nums[i-1] == right):   # 현재 인덱스 앞까지의 합 == 뒤까지의 합이면 인덱스 반환
                return i
        
        return -1

'''
Runtime: 152 ms, faster than 49.59% of Python3 online submissions for Find Pivot Index.
Memory Usage: 15.5 MB, less than 26.75% of Python3 online submissions for Find Pivot Index.
'''