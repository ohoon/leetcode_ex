'''
999.
Available Captures for Rook
https://leetcode.com/problems/available-captures-for-rook/
'''

class Solution:
    def numRookCaptures(self, board: list(list(str))) -> int:
        answer = 0
        X, Y = len(board[0]), len(board)
        x, y = -1, -1
        for i in range(Y):                  # 룩의 위치를 찾아 x, y에 인덱스 저장
            for j in range(X):
                if board[i][j] == 'R':
                    x, y = j, i
                    break
        
        for top in range(y-1, -1, -1):      # 위쪽 방향으로 탐색
            if board[top][x] == 'B':
                break
            
            if board[top][x] == 'p':
                answer += 1
                break
        
        for left in range(x-1, -1, -1):     # 왼쪽 방향으로 탐색
            if board[y][left] == 'B':
                break
            
            if board[y][left] == 'p':
                answer += 1
                break
                
        for right in range(x+1, X):         # 오른쪽 방향으로 탐색
            if board[y][right] == 'B':
                break
            
            if board[y][right] == 'p':
                answer += 1
                break
                
        for bottom in range(y+1, Y):        # 아래쪽 방향으로 탐색
            if board[bottom][x] == 'B':
                break
            
            if board[bottom][x] == 'p':
                answer += 1
                break
        
        return answer

'''
Runtime: 32 ms, faster than 70.52% of Python3 online submissions for Available Captures for Rook.
Memory Usage: 14.3 MB, less than 63.65% of Python3 online submissions for Available Captures for Rook.
'''
