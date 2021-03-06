'''
941.
Valid Mountain Array
https://leetcode.com/problems/valid-mountain-array/
'''

class Solution:
    def validMountainArray(self, arr: list(int)) -> bool:
        goDown = False          # 현재 내려가는 중인가?
        
        for i in range(1, len(arr)):
            diff = arr[i] - arr[i-1]        # 기울기 방향을 나타내기 위함
            
            if diff > 0:
                if goDown:                  # 현재 내려가는 상태에서 기울기가 +가 나오면 peak가 2개 이상이므로 False 반환
                    return False
                
            if diff == 0:                   # 기울기가 0이면 조건이 성립하지 않으므로 False 반환
                return False
            
            if diff < 0:
                if i == 1:                  # 처음부터 기울기가 -이면 peak가 없으므로 False 반환
                    return False
                
                if not goDown:              # 올라가는 상태에서 기울기가 -이 나오면 내려가는 상태로 변경
                    goDown = True
        
        return len(arr) >= 3 and goDown     # 최소 지점인 3을 가지고 있고 내려가는 상태로 for문을 마칠 때만 True 반환

'''
Runtime: 188 ms, faster than 98.08% of Python3 online submissions for Valid Mountain Array.
Memory Usage: 15.7 MB, less than 10.85% of Python3 online submissions for Valid Mountain Array.
'''

'''
다른 풀이

class Solution(object):
    def validMountainArray(self, A):
        N = len(A)
        i = 0

        # walk up
        while i+1 < N and A[i] < A[i+1]:
            i += 1

        # peak can't be first or last
        if i == 0 or i == N-1:
            return False

        # walk down
        while i+1 < N and A[i] > A[i+1]:
            i += 1

        return i == N-1

위 코드는 문제 풀이 접근을
산을 끝까지 오를 때의 peak 위치와
산을 끝까지 내려올 때의 peak 위치를 검증하여 판단하는 방식으로 풀이했음
현재 커서가 오르는 중인지 내려가는 중인지 변수로 저장하여 검증하는 나의 방식과는 달라 신선했다.

'''