'''
242.
Valid Anagram
https://leetcode.com/problems/valid-anagram/
'''

from collections import Counter

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return Counter(s) == Counter(t)

'''
Runtime: 28 ms, faster than 99.25% of Python3 online submissions for Valid Anagram.
Memory Usage: 14.4 MB, less than 33.73% of Python3 online submissions for Valid Anagram.
'''