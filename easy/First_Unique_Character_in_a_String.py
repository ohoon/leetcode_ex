'''
387.
First Unique Character in a String
https://leetcode.com/problems/first-unique-character-in-a-string/
'''

from collections import Counter

class Solution:
    def firstUniqChar(self, s: str) -> int:
        counter = Counter(s)
        for i in range(len(s)):
            if counter[s[i]] == 1:      # 중복되지 않은 문자를 만나면 인덱스 반환
                return i
        
        return -1       # s가 모두 중복된 문자들로 이루어져있거나 공백인 경우

'''
Runtime: 84 ms, faster than 90.09% of Python3 online submissions for First Unique Character in a String.
Memory Usage: 14.3 MB, less than 21.59% of Python3 online submissions for First Unique Character in a String.
'''