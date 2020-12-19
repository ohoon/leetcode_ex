'''
657.
Robot Return to Origin
https://leetcode.com/problems/robot-return-to-origin/
'''

class Solution:
    def judgeCircle(self, moves: str) -> bool:
        x, y = 0, 0         # x, y축 위치
        for m in moves:
            if m == 'L':        # 왼쪽으로 이동
                x -= 1
                continue
            
            if m == 'R':        # 오른쪽으로 이동
                x += 1
                continue
                
            if m == 'U':        # 위로 이동
                y += 1
                continue
            
            if m == 'D':        # 아래로 이동
                y -= 1
        
        return x == 0 and y == 0        # 원점인가?

'''
Runtime: 64 ms, faster than 47.16% of Python3 online submissions for Robot Return to Origin.
Memory Usage: 14.5 MB, less than 25.21% of Python3 online submissions for Robot Return to Origin.
'''