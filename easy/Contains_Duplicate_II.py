'''
219.
Contains Duplicate II
https://leetcode.com/problems/contains-duplicate-ii/
'''

class Solution:
    def containsNearbyDuplicate(self, nums: list(int), k: int) -> bool:
        hash_map = {}
        for i in range(len(nums)):
            if nums[i] in hash_map and hash_map[nums[i]] >= i - k:      # 해당 숫자가 이미 해시맵에 존재하고 인덱스 간의 거리가 k 이하면 True 반환
                return True
            
            hash_map[nums[i]] = i

'''
Runtime: 84 ms, faster than 85.97% of Python3 online submissions for Contains Duplicate II.
Memory Usage: 21.6 MB, less than 45.45% of Python3 online submissions for Contains Duplicate II.
'''