'''
492.
Construct the Rectangle
https://leetcode.com/problems/construct-the-rectangle/
'''

class Solution:
    def constructRectangle(self, area: int) -> list(int):
        for i in range(int(area ** 0.5), 0, -1):        # 제곱근에서 시작하여 약수 쌍을 탐색
            if area % i == 0:
                return [area // i, i]

'''
Runtime: 28 ms, faster than 88.87% of Python3 online submissions for Construct the Rectangle.
Memory Usage: 14.3 MB, less than 11.65% of Python3 online submissions for Construct the Rectangle.
'''