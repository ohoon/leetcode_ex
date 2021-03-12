'''
997.
Find the Town Judge
https://leetcode.com/problems/find-the-town-judge/
'''

class Solution:
    def findJudge(self, N: int, trust: list(list(int))) -> int:
        hash_map = {p: 0 for p in range(1, N + 1)}      # 각 사람 별로 신뢰받는 횟수
        pool = set(range(1, N + 1))                     # 아무도 신뢰하지 않는 사람을 가려내기 위한 pool
        for p1, p2 in trust:
            pool -= {p1}                                # 누군가 신뢰하고 있는 사람을 pool에서 제거
            hash_map[p2] += 1                           # p2의 신뢰받는 횟수 +1
        
        if not pool or len(pool) > 1:                   # 아무도 신뢰하지 않는 사람이 없거나 여러명이면 -1 반환
            return -1
        
        judge = next(iter(pool))                        # 아무도 신뢰하지 않는 단 한 사람 judge
        
        if hash_map[judge] != N - 1:                    # judge가 신뢰받는 횟수가 N-1이 아니면 -1 반환
            return -1
        
        return judge                                    # judge 라벨 번호 반환

'''
Runtime: 732 ms, faster than 72.04% of Python3 online submissions for Find the Town Judge.
Memory Usage: 19.1 MB, less than 5.00% of Python3 online submissions for Find the Town Judge.
'''
