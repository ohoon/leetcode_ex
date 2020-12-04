'''
506.
Relative Ranks
https://leetcode.com/problems/relative-ranks/
'''

class Solution:
    def findRelativeRanks(self, nums: list(int)) -> list(str):
        hash_map = {}
        sort_nums = sorted(nums, reverse=True)
        for i in range(len(sort_nums)):
            if i == 0:
                hash_map[sort_nums[i]] = 'Gold Medal'
                continue
            
            if i == 1:
                hash_map[sort_nums[i]] = 'Silver Medal'
                continue
                
            if i == 2:
                hash_map[sort_nums[i]] = 'Bronze Medal'
                continue
            
            hash_map[sort_nums[i]] = str(i + 1)
        
        return [hash_map[n] for n in nums]

'''
Runtime: 68 ms, faster than 67.05% of Python3 online submissions for Relative Ranks.
Memory Usage: 15.3 MB, less than 23.37% of Python3 online submissions for Relative Ranks.
'''