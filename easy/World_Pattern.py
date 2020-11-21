'''
290.
World Pattern
https://leetcode.com/problems/word-pattern/
'''

class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        s_split = s.split()
        hash_map = {}
        
        if len(pattern) != len(s_split):        # 패턴과 문자열의 개수가 맞아 떨어지지 않으면 False
            return False
        
        for p, x in zip(pattern, s_split):
            if p in hash_map:
                if hash_map[p] != x:            # 등록된 패턴의 문자가 아닌 다른 문자가 나왔을 경우 False
                    return False
                
                continue
            
            if x in hash_map.values():          # 이미 패턴으로 등록된 문자가 다른 패턴에서 나왔을 경우 False
                return False
            
            hash_map[p] = x
        
        return True

'''
Runtime: 20 ms, faster than 98.42% of Python3 online submissions for Word Pattern.
Memory Usage: 14.4 MB, less than 6.43% of Python3 online submissions for Word Pattern.
'''