'''
217.
Contains Duplicate
https://leetcode.com/problems/contains-duplicate/
'''

class Solution:
    def containsDuplicate(self, nums: list(int)) -> bool:
        hash_map = {}
        for n in nums:
            if n in hash_map:   # 앞에서 나온 숫자가 있으면 True 반환
                return True
            
            hash_map[n] = n
        
        return False

'''
Runtime: 108 ms, faster than 93.53% of Python3 online submissions for Contains Duplicate.
Memory Usage: 21 MB, less than 9.43% of Python3 online submissions for Contains Duplicate.
'''