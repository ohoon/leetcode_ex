'''
892.
Surface Area of 3D Shapes
https://leetcode.com/problems/surface-area-of-3d-shapes/
'''

class Solution:
    def surfaceArea(self, grid: list(list(int))) -> int:
        answer = 0
        n = len(grid)
        
        for i in range(n):
            for j in range(n):
                if i == 0:                                      # 첫 줄은 자신의 높이 길이의 바깥 면(북쪽)을 가짐
                    answer += grid[i][j]
                else:                                           # 나머지 줄은 이전 줄의 높이와 현재 높이 차이만큼의 면(북쪽)을 가짐
                    answer += abs(grid[i][j] - grid[i-1][j])
                    
                if i == n - 1:                                  # 마지막 줄은 자신의 높이 길이의 바깥 면(남쪽)을 가짐
                    answer += grid[i][j]
                
                if j == 0:                                      # 첫 칸은 자신의 높이 길이의 바깥 면(서쪽)을 가짐
                    answer += grid[i][j]
                else:                                           # 나머지 칸은 이전 칸의 높이와 현재 높이 차이만큼의 면(서쪽)을 가짐
                    answer += abs(grid[i][j] - grid[i][j-1])
                    
                if j == n - 1:                                  # 마지막 칸은 자신의 높이 길이의 바깥 면(동쪽)을 가짐
                    answer += grid[i][j]
                    
                if grid[i][j] != 0:                             # 모든 칸은 0이 아닌 이상 1, 1의 위, 아래 면을 가짐
                    answer += 2
        
        return answer

'''
Runtime: 84 ms, faster than 86.26% of Python3 online submissions for Surface Area of 3D Shapes.
Memory Usage: 14.2 MB, less than 78.27% of Python3 online submissions for Surface Area of 3D Shapes.
'''