'''
747.
Largest Number At Least Twice of Others
https://leetcode.com/problems/largest-number-at-least-twice-of-others/
'''

class Solution:
    def dominantIndex(self, nums: list(int)) -> int:
        length = len(nums)
        if length == 1:
            return 0
        
        first, second = (0, 1) if nums[0] >= nums[1] else (1, 0)        # first, second 초기화
        for i in range(2, length):                                      # largest한 first와 그 다음으로 larger한 second를 구하는 반복문
            if nums[i] > nums[second]:
                if nums[i] > nums[first]:
                    second = first
                    first = i
                    continue
                    
                second = i
        
        if nums[first] < nums[second] * 2:                              # first가 second의 2배보다 작으면 -1 반환
            return -1
        
        return first                                                    # 가장 큰 수 first 반환

'''
Runtime: 28 ms, faster than 95.69% of Python3 online submissions for Largest Number At Least Twice of Others.
Memory Usage: 14.3 MB, less than 9.02% of Python3 online submissions for Largest Number At Least Twice of Others.
'''