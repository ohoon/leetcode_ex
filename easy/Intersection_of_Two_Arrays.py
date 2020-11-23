'''
349.
Intersection of Two Arrays
https://leetcode.com/problems/intersection-of-two-arrays/
'''

class Solution:
    def intersection(self, nums1: list(int), nums2: list(int)) -> list(int):
        return list(set(nums1) & set(nums2))

'''
Runtime: 28 ms, faster than 99.97% of Python3 online submissions for Intersection of Two Arrays.
Memory Usage: 14.4 MB, less than 5.11% of Python3 online submissions for Intersection of Two Arrays.
'''