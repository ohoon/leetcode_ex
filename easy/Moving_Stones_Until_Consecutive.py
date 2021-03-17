'''
1033.
Moving Stones Until Consecutive
https://leetcode.com/problems/moving-stones-until-consecutive/
'''

class Solution:
    def numMovesStones(self, a: int, b: int, c: int) -> list(int):
        stones = sorted([a, b, c])
        diff = [stones[1] - stones[0], stones[2] - stones[1]]
        if diff.count(1) == 2:              # 이미 연속적인 배열일 경우
            minimum = 0
        elif 1 in diff or 2 in diff:        # 하나만 옮기면 연속적이게 되는 경우
            minimum = 1
        else:                               # 나머지의 경우는 2번만 움직이면 됨
            minimum = 2
            
        maximum = diff[0] + diff[1] - 2     # 한 칸씩 움직이면 각각의 diff - 1만큼 움직이는 것으로 연속적이게 됨
        
        return [minimum, maximum]

'''
Runtime: 20 ms, faster than 98.97% of Python3 online submissions for Moving Stones Until Consecutive.
Memory Usage: 14.2 MB, less than 81.54% of Python3 online submissions for Moving Stones Until Consecutive.
'''
