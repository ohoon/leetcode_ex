'''
205.
Isomorphic Strings
https://leetcode.com/problems/isomorphic-strings/
'''

class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        hash_map = {}
        for x, y in zip(s, t):
            if x in hash_map and hash_map[x] != y:      # 매칭된 문자와 해시맵에 등록된 예상 결과가 다를 때
                return False
            
            if x not in hash_map and y in hash_map.values(): # x는 등록되지 않았지만 y는 이미 매칭된 결과에 사용되었을 때
                return False
            
            hash_map[x] = y     # 각 문자 x, y를 x -> y 형태로 해시맵에 저장
            
        return True

'''
Runtime: 28 ms, faster than 98.51% of Python3 online submissions for Isomorphic Strings.
Memory Usage: 14.5 MB, less than 27.44% of Python3 online submissions for Isomorphic Strings.
'''