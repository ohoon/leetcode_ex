'''
26.
Remove Duplicates from Sorted Array
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
'''

class Solution:
    def removeDuplicates(self, nums: list(int)) -> int:
        length = len(nums)
        cursor = 0
        
        for i in range(length):
            if (nums[i] != nums[cursor]):       # cursor에 위치한 수와 다른 수를 발견
                cursor += 1                     # cursor을 1 증가시키고 그 자리에 새로운 수를 삽입
                nums[cursor] = nums[i]
        
        return cursor + 1
        

'''
Runtime: 72 ms, faster than 98.30% of Python3 online submissions for Remove Duplicates from Sorted Array.
Memory Usage: 15.6 MB, less than 83.94% of Python3 online submissions for Remove Duplicates from Sorted Array.
'''