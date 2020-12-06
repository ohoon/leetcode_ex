'''
521.
Longest Uncommon Subsequence I
https://leetcode.com/problems/longest-uncommon-subsequence-i/
'''

class Solution:
    def findLUSlength(self, a: str, b: str) -> int:
        return max(len(a), len(b)) if a != b else -1

'''
Runtime: 24 ms, faster than 89.07% of Python3 online submissions for Longest Uncommon Subsequence I.
Memory Usage: 14.3 MB, less than 12.33% of Python3 online submissions for Longest Uncommon Subsequence I.
'''

'''
여담

문제 설명이 너무 난해해서 이해하는데 힘들었다.
문제 의도를 알고나니까 허무하게 한줄로 풀이가 끝났음...

'''