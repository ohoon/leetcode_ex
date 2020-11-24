'''
383.
Ransom Note
https://leetcode.com/problems/ransom-note/
'''

from collections import Counter

class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        return len(Counter(ransomNote) - Counter(magazine)) == 0        # ransomNote의 구성 문자와 magazine의 구성 문자의 차집합? 개념

'''
Runtime: 52 ms, faster than 57.40% of Python3 online submissions for Ransom Note.
Memory Usage: 14.4 MB, less than 59.13% of Python3 online submissions for Ransom Note.
'''