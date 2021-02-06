'''
874.
Walking Robot Simulation
https://leetcode.com/problems/walking-robot-simulation/
'''

class Solution:
    def robotSim(self, commands: list(int), obstacles: list(list(int))) -> int:
        answer = 0
        current = [0, 0]
        direction = 0                           # 0: +x, 1: +y, 2: -x, 3: -y
        obstacles = set(map(tuple, obstacles))
        
        for cmd in commands:
            if cmd == -1:                       # 우측으로 회전
                direction = (direction + 1) % 4
                continue
            
            if cmd == -2:                       # 좌측으로 회전
                direction = (direction - 1) % 4
                continue
                
            if direction == 0:
                end = current[1] + cmd
                while current[1] < end and (current[0], current[1]+1) not in obstacles:         # 방해물에 걸리지 않을때까지 이동하고 최대값 갱신
                    current[1] += 1
                    
                answer = max(answer, current[0] ** 2 + current[1] ** 2)
                continue

            if direction == 1:
                end = current[0] + cmd
                while current[0] < end and (current[0]+1, current[1]) not in obstacles:
                    current[0] += 1
                    
                answer = max(answer, current[0] ** 2 + current[1] ** 2)
                continue
                
            if direction == 2:
                end = current[1] - cmd
                while current[1] > end and (current[0], current[1]-1) not in obstacles:
                    current[1] -= 1
                    
                answer = max(answer, current[0] ** 2 + current[1] ** 2)
                continue
                
            if direction == 3:
                end = current[0] - cmd
                while current[0] > end and (current[0]-1, current[1]) not in obstacles:
                    current[0] -= 1
                    
                answer = max(answer, current[0] ** 2 + current[1] ** 2)
                continue
        
        return answer

'''
Runtime: 372 ms, faster than 58.79% of Python3 online submissions for Walking Robot Simulation.
Memory Usage: 20.4 MB, less than 16.33% of Python3 online submissions for Walking Robot Simulation.
'''

'''
다른 풀이

class Solution(object):
    def robotSim(self, commands, obstacles):
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        x = y = di = 0
        obstacleSet = set(map(tuple, obstacles))
        ans = 0

        for cmd in commands:
            if cmd == -2:  #left
                di = (di - 1) % 4
            elif cmd == -1:  #right
                di = (di + 1) % 4
            else:
                for k in xrange(cmd):
                    if (x+dx[di], y+dy[di]) not in obstacleSet:
                        x += dx[di]
                        y += dy[di]
                        ans = max(ans, x*x + y*y)

        return ans

obstacles를 최적화하는데 시간을 많이 썼는데, 여기서는 set(map())을 사용해서 최적화하였음
나머지 풀이는 비슷하게 한 것 같은데 아쉽다.

'''