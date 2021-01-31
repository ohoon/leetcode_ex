'''
859.
Buddy Strings
https://leetcode.com/problems/buddy-strings/
'''

from collections import Counter

class Solution:
    def buddyStrings(self, A: str, B: str) -> bool:
        if Counter(A) != Counter(B):                # 구성 요소의 종류, 개수가 같은지 확인
            return False
        
        if A == B and len(set(A)) != len(A):        # 완전히 같고 2번 이상 나온 요소가 있으면 같은 요소끼리 바꾸면 되니까 True
            return True
        
        return len(list(filter(lambda x: x[0] != x[1], zip(A, B)))) == 2        # A와 B의 각 요소를 비교한 뒤 서로 다른 경우가 2번이면 True

'''
Runtime: 72 ms, faster than 83.82% of Python3 online submissions for Peak Index in a Mountain Array.
Memory Usage: 15.3 MB, less than 57.96% of Python3 online submissions for Peak Index in a Mountain Array.
'''