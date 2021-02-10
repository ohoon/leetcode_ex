'''
884.
Uncommon Words from Two Sentences
https://leetcode.com/problems/uncommon-words-from-two-sentences/
'''

from collections import Counter

class Solution:
    def uncommonFromSentences(self, A: str, B: str) -> list(str):
        counter = Counter(A.split(" ") + B.split(" "))              # A와 B의 문자들을 모아 counter 생성
        return list(filter(lambda x: counter[x] == 1, counter.keys()))      # 문자 빈도가 1인 것만 filtering해서 반환

'''
Runtime: 32 ms, faster than 62.14% of Python3 online submissions for Uncommon Words from Two Sentences.
Memory Usage: 14 MB, less than 99.62% of Python3 online submissions for Uncommon Words from Two Sentences.
'''