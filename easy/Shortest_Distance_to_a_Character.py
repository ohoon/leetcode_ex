'''
821.
Shortest Distance to a Character
https://leetcode.com/problems/shortest-distance-to-a-character/
'''

class Solution:
    def shortestToChar(self, S: str, C: str) -> list(int):
        split = S.split(C)                  # S를 C를 기준으로 쪼개어 조각의 길이로 최소 거리를 추정
        length = len(split)
        answer = []
        for i in range(len(split)):
            s_length = len(split[i])
            for j in range(s_length):
                distance_from_left = (j + 1) if i > 0 else float("inf")                     # 자신의 좌측에 있는 C까지의 거리, 첫번째 조각은 좌측의 C가 존재하지 않으므로 따로 구하지 않음
                distance_from_right = (s_length - j) if i < length - 1 else float("inf")    # 자신의 우측에 있는 C까지의 거리, 마지막 조각은 우측의 C가 존재하지 않으므로 따로 구하지 않음
                answer.append(min(distance_from_left, distance_from_right))                 # 최소 거리를 구해서 answer에 더해줌
            
            if i < length - 1:                                                              # C가 나온 경우 0을 삽입
                answer.append(0)
        
        return answer

'''
Runtime: 40 ms, faster than 74.28% of Python3 online submissions for Shortest Distance to a Character.
Memory Usage: 14.3 MB, less than 46.30% of Python3 online submissions for Shortest Distance to a Character.
'''

'''
다른 풀이

class Solution(object):
    def shortestToChar(self, S, C):
        prev = float('-inf')
        ans = []
        for i, x in enumerate(S):
            if x == C: prev = i
            ans.append(i - prev)

        prev = float('inf')
        for i in xrange(len(S) - 1, -1, -1):
            if S[i] == C: prev = i
            ans[i] = min(ans[i], prev - i)

        return ans

split으로 나눠 one-pass하지 않고 왼쪽부터 한번, 오른쪽부터 한번 two-pass해서 최적의 해를 구하는 방법이다.

'''