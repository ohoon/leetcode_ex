'''
1518.
Water Bottles
https://leetcode.com/problems/water-bottles/
'''

class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        answer = 0
        empty = 0
        while numBottles > 0:                               # full water bottle이 존재할 동안 계속 반복
            answer += numBottles
            empty += numBottles                             # 마신 bottle은 empty bottles에 추가
            numBottles, empty = divmod(empty, numExchange)  # empty bottle을 exchange하여 full bottle로 교환

        return answer

'''
Runtime: 32 ms, faster than 44.31% of Python3 online submissions for Water Bottles.
Memory Usage: 14.2 MB, less than 43.14% of Python3 online submissions for Water Bottles.
'''