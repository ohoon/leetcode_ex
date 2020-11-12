'''
198.
House Robber
https://leetcode.com/problems/house-robber/
'''

class Solution:
    def rob(self, nums: list(int)) -> int:
        if not nums:
            return 0
        
        # 동적 프로그래밍식 풀이
        for i in range(2, len(nums)):
            if i == 2:                  # nums[i-3]이 없으므로 num[i-2]를 더해줌
                nums[i] += nums[0]
                continue
            
            nums[i] += max(nums[i-2], nums[i-3])
        
        return max(nums[-2:])

'''
Runtime: 24 ms, faster than 95.88% of Python3 online submissions for House Robber.
Memory Usage: 14.1 MB, less than 99.98% of Python3 online submissions for House Robber.
'''

'''
다른 사람의 풀이

class Solution:
    def rob(self, nums: List[int]) -> int:
        # edge cases:
        if len(nums) == 0: return 0
        if len(nums) == 1: return nums[0]
        if len(nums) == 2: return max(nums)
        
        # dynamic programming - decide each problem by its sub-problems:
        dp = [0]*len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1], nums[i]+dp[i-2])
        
        return dp[-1]

나의 풀이랑 똑같이 DP로 풀어서 대략적으로 같은 로직이지만
위의 풀이에는 dp배열을 따로 만들어서 기록하는 방식을 사용했다.
로직을 이해하기엔 위의 풀이가 더 좋은거 같다.

'''