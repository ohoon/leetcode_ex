'''
557.
Reverse Words in a String III
https://leetcode.com/problems/reverse-words-in-a-string-iii/
'''

class Solution:
    def reverseWords(self, s: str) -> str:
        return " ".join([x[::-1] for x in s.split(' ')])

'''
Runtime: 32 ms, faster than 73.60% of Python3 online submissions for Reverse Words in a String III.
Memory Usage: 14.7 MB, less than 91.22% of Python3 online submissions for Reverse Words in a String III.
'''