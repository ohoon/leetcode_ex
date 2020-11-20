'''
283.
Move Zeroes
https://leetcode.com/problems/move-zeroes/
'''

class Solution:
    def moveZeroes(self, nums: list(int)) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        cur = 0     # 최근에 발견된 0의 인덱스
        for i in range(len(nums)):
            if nums[i] == 0:        # 0이 아닌 수를 찾아 탐색
                continue
                
            for j in range(cur, i):
                if nums[j] == 0:            # 0인 요소와 swap하고 cur 갱신
                    nums[i], nums[j] = nums[j], nums[i]
                    cur = j
                    break

'''
Runtime: 48 ms, faster than 68.14% of Python3 online submissions for Move Zeroes.
Memory Usage: 15.3 MB, less than 39.66% of Python3 online submissions for Move Zeroes.
'''