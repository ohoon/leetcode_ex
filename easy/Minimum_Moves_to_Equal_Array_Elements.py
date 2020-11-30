'''
453.
Minimum Moves to Equal Array Elements
https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
'''

class Solution:
    def minMoves(self, nums: list(int)) -> int:
        if not nums:
            return 0
        
        minimum = min(nums)
        
        return sum([(n - minimum) for n in nums])       # 최소값과 각 값의 차이만큼 증가시키면서 탐색하면 마지막엔 모든 값이 같아지기 때문

'''
Runtime: 248 ms, faster than 55.27% of Python3 online submissions for Minimum Moves to Equal Array Elements.
Memory Usage: 15.6 MB, less than 55.18% of Python3 online submissions for Minimum Moves to Equal Array Elements.
'''