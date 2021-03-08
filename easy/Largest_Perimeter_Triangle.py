'''
976.
Largest Perimeter Triangle
https://leetcode.com/problems/largest-perimeter-triangle/
'''

class Solution:
    def largestPerimeter(self, nums: list(int)) -> int:
        nums.sort(reverse=True)         # 내림차순 정렬
        for i in range(len(nums) - 2):
            if nums[i] < nums[i+1] + nums[i+2]:     # 빗변 < 나머지 두 변의 합 일 경우에만 삼각형 성립
                return sum(nums[i:i+3])             # 삼각형의 둘레 반환
        
        return 0                                    # 성립되는 삼각형이 없으면 0 반환

'''
Runtime: 188 ms, faster than 69.49% of Python3 online submissions for Largest Perimeter Triangle.
Memory Usage: 15.6 MB, less than 31.25% of Python3 online submissions for Largest Perimeter Triangle.
'''