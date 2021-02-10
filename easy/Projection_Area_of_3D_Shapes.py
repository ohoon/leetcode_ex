'''
883.
Projection Area of 3D Shapes
https://leetcode.com/problems/projection-area-of-3d-shapes/
'''

class Solution:
    def projectionArea(self, grid: list(list(int))) -> int:
        xy = 0
        yz = sum([max(x[i] for x in grid) for i in range(len(grid[0]))])        # 같은 i열에 있는 모든 원소들의 최대값들의 합
        xz = sum(max(x) for x in grid)                                          # 같은 행에 있는 모든 원소들의 최대값들의 합
        
        for x in grid:                                                          # 0이 아닌 원소 수만큼 xy 증가
            for y in x:
                if y > 0:
                    xy += 1
        
        return xy + yz + xz

'''
Runtime: 64 ms, faster than 99.38% of Python3 online submissions for Projection Area of 3D Shapes.
Memory Usage: 14.3 MB, less than 60.80% of Python3 online submissions for Projection Area of 3D Shapes.
'''