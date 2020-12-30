'''
746.
Min Cost Climbing Stairs
https://leetcode.com/problems/min-cost-climbing-stairs/
'''

class Solution:
    def minCostClimbingStairs(self, cost: list(int)) -> int:
        for i in range(2, len(cost)):               # Dynamic Programming
            cost[i] += min(cost[i-2], cost[i-1])    # 앞에서부터 더해가며 최소값이 나오는 경우의 수로 동적으로 계산하며 전개
        
        return min(cost[-2], cost[-1])              # 2칸 전진으로 들어오는 경우와 1칸 전진으로 들어오는 경우 중 최소 값 반환


'''
Runtime: 48 ms, faster than 96.38% of Python3 online submissions for Min Cost Climbing Stairs.
Memory Usage: 14.3 MB, less than 84.33% of Python3 online submissions for Min Cost Climbing Stairs.
'''