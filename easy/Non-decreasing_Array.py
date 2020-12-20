'''
665.
Non-decreasing Array
https://leetcode.com/problems/non-decreasing-array/
'''

class Solution:
    def checkPossibility(self, nums: list(int)) -> bool:
        modify = False
        length = len(nums)
        for i in range(length - 1):
            if nums[i] > nums[i+1]:         # increasing하면
                if modify:                  # 이미 이전에 수정을 한번 했으면 False 반환
                    return False
                
                if i == 0 or nums[i-1] <= nums[i+1]:
                    nums[i] = nums[i+1]
                elif i == length - 2 or nums[i] <= nums[i+2]:
                    nums[i+1] = nums[i]
                else:
                    return False
                
                modify = True
        
        return True

'''
Runtime: 180 ms, faster than 69.02% of Python3 online submissions for Non-decreasing Array.
Memory Usage: 15.3 MB, less than 36.70% of Python3 online submissions for Non-decreasing Array.
'''