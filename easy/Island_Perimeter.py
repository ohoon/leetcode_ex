'''
463.
Island Perimeter
https://leetcode.com/problems/island-perimeter/
'''

class Solution:
    def islandPerimeter(self, grid: list(list(int))) -> int:
        row = len(grid)
        col = len(grid[0])
        answer = 0
        for i in range(row):
            for j in range(col):
                if grid[i][j] == 0:
                    continue
                
                # 육지를 만나면 상하좌우 주변에도 육지가 있는지 탐색해서 각 변수에 저장
                up = grid[i-1][j] if i > 0 else 0
                down = grid[i+1][j] if i < row - 1 else 0
                left = grid[i][j-1] if j > 0 else 0
                right = grid[i][j+1] if j < col - 1 else 0
                
                answer += 4 - (up + down + left + right)            # 육지와 바다의 인접면 = 모서리 = 4 - 주변 육지의 개수
        
        return answer

'''
Runtime: 496 ms, faster than 63.02% of Python3 online submissions for Island Perimeter.
Memory Usage: 14.6 MB, less than 43.36% of Python3 online submissions for Island Perimeter.
'''