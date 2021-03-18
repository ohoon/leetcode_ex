'''
1037.
Valid Boomerang
https://leetcode.com/problems/valid-boomerang/
'''

class Solution:
    def isBoomerang(self, points: List[List[int]]) -> bool:
        points.sort(key=lambda x: x[0])
        if points[0] == points[1] or points[1] == points[2]:        # distinct하지 않을 시 False 반환
            return False
        
        dx1, dy1 = points[1][0] - points[0][0], points[1][1] - points[0][1]     # points[1]와 points[0]의 기울기를 계산하기 위한 dx, dy
        dx2, dy2 = points[2][0] - points[1][0], points[2][1] - points[1][1]     # points[2]와 points[1]의 기울기를 계산하기 위한 dx, dy
        a1 = (dy1 / dx1) if dx1 != 0 else float("inf")                          # points[1]와 points[0]의 기울기
        a2 = (dy2 / dx2) if dx2 != 0 else float("inf")                          # points[2]와 points[1]의 기울기
        return a1 != a2
      
'''
Runtime: 32 ms, faster than 72.69% of Python3 online submissions for Valid Boomerang.
Memory Usage: 14.2 MB, less than 77.69% of Python3 online submissions for Valid Boomerang.
'''
