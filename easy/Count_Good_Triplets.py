'''
1534.
Count Good Triplets
https://leetcode.com/problems/count-good-triplets/
'''

from itertools import combinations

class Solution:
    def countGoodTriplets(self, arr: List[int], a: int, b: int, c: int) -> int:
        combi = combinations(arr, 3)    # 3개의 요소를 찾는 조합 쌍들
        answer = 0
        for x, y, z in combi:
            if (abs(x - y) <= a and abs(y - z) <= b and abs(x - z) <= c):   # 조건에 해당되면 answer 증가
                answer += 1
                
        return answer

'''
Runtime: 548 ms, faster than 68.47% of Python3 online submissions for Count Good Triplets.
Memory Usage: 14.2 MB, less than 64.41% of Python3 online submissions for Count Good Triplets.
'''
