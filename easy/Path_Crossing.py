'''
1496.
Path Crossing
https://leetcode.com/problems/path-crossing/
'''

class Solution:
    def isPathCrossing(self, path: str) -> bool:
        visited = {"00"}
        x, y = 0, 0
        for p in path:
            if p == 'N':
                y += 1
            elif p == 'S':
                y -= 1
            elif p == 'E':
                x += 1
            else:
                x -= 1

            pos = str(x) + str(y)           # set에 넣기 위한 string 변환
            if pos in visited:              # 방문한 곳이면 True 반환
                return True

            visited.add(pos)                # 방문한 곳 등록

        return False

'''
Runtime: 28 ms, faster than 80.35% of Python3 online submissions for Path Crossing.
Memory Usage: 14.3 MB, less than 57.95% of Python3 online submissions for Path Crossing.
'''