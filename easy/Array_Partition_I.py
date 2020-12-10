'''
561.
Array Partition I
https://leetcode.com/problems/array-partition-i/
'''

class Solution:
    def arrayPairSum(self, nums: list(int)) -> int:
        return sum(x for i, x in enumerate(sorted(nums)) if i % 2 == 0)

'''
Runtime: 264 ms, faster than 52.37% of Python3 online submissions for Array Partition I.
Memory Usage: 16.9 MB, less than 11.84% of Python3 online submissions for Array Partition I.
'''

'''
다른 사람의 풀이

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort()
        return(sum(nums[::2]))

nums[::2]를 사용하면 if i % 2 == 0을 하지 않아도 간단하게 구현이 가능하다.

'''