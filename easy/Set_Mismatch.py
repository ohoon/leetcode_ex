'''
645.
Set Mismatch
https://leetcode.com/problems/set-mismatch/
'''

class Solution:
    def findErrorNums(self, nums: list(int)) -> list(int):
        hash_map = {}
        for n in nums:
            if n in hash_map:               # 중복된 요소를 찾으면
                return [n, list(set(range(1, len(nums) + 1)) - set(nums))[0]]           # [중복된 요소, 누락된 요소]
            
            hash_map[n] = n

'''
Runtime: 820 ms, faster than 69.19% of Python3 online submissions for Maximum Average Subarray I.
Memory Usage: 18.1 MB, less than 5.25% of Python3 online submissions for Maximum Average Subarray I.
'''