'''
748.
Shortest Completing Word
https://leetcode.com/problems/shortest-completing-word/
'''

from collections import Counter

class Solution:
    def shortestCompletingWord(self, licensePlate: str, words: list(str)) -> str:
        shortest = ""
        letters = "".join(x.lower() for x in licensePlate if x.isalpha())       # 알파벳만 뽑아서 저장
        lc = Counter(letters)               # letters의 알파벳 갯수를 카운트한 딕셔너리
        for w in words:
            if len(shortest) > 0 and len(w) >= len(shortest):                   # 현재까지 구한 shortest word보다 긴 것들은 무시
                continue
            
            wc = Counter(w)                 # word의 알파벳 갯수를 카운트한 딕셔너리
            if not (lc - wc):               # not(lc 차집합 wc), lc의 모든 알파벳이 wc에 있으면 not(공집합)이 되어 shortest에 해당 word를 저장
                shortest = w
        
        return shortest

'''
Runtime: 96 ms, faster than 40.59% of Python3 online submissions for Shortest Completing Word.
Memory Usage: 14.5 MB, less than 67.86% of Python3 online submissions for Shortest Completing Word.
'''