'''
520.
Detect Capital
https://leetcode.com/problems/detect-capital/
'''

class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        return word.isupper() or word.islower() or word.istitle()

'''
Runtime: 24 ms, faster than 94.05% of Python3 online submissions for Detect Capital.
Memory Usage: 14.4 MB, less than 13.19% of Python3 online submissions for Detect Capital.
'''