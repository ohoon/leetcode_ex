'''
812.
Largest Triangle Area
https://leetcode.com/problems/largest-triangle-area/
'''

class Solution:
    def largestTriangleArea(self, points: list(list(int))) -> float:
        length = len(points)
        maximum = 0
        for i in range(length):
            for j in range(i + 1, length):
                for k in range(j + 1, length):
                    p1, p2, p3 = points[i], points[j], points[k]
                    x, y = (p1[0], p2[0], p3[0]), (p1[1], p2[1], p3[1])             # 세 점의 각 x값과 y값끼리 재조립
                    maximum = max(abs((x[0] - x[1]) * (y[0] - y[2]) - (x[0] - x[2]) * (y[0] - y[1])) / 2, maximum)      # 세 점으로 만든 삼각형의 넓이를 구해서 최대 넓이와 비교
        
        return maximum

'''
Runtime: 152 ms, faster than 39.13% of Python3 online submissions for Largest Triangle Area.
Memory Usage: 14.4 MB, less than 28.62% of Python3 online submissions for Largest Triangle Area.
'''

'''
여담

문제 풀이 자체는 쉽지만 수학적 지식이 많이 요구되는 문제로 좋은 알고리즘 문제는 아닌 것 같다.

'''