'''
720.
Longest Word in Dictionary
https://leetcode.com/problems/longest-word-in-dictionary/
'''

class Solution:
    def longestWord(self, words: list(str)) -> str:
        hash_map = {}
        answer = ''
        for w in words:                 # 해시맵에 등록
            hash_map[w] = w
        
        for w in words:
            if len(w) >= len(answer) and all(w[:i] in hash_map for i in range(1, len(w))):      # 글자수가 answer 이상이고 모든 subset이 해시맵에 존재하면 answer에 등록
                answer = w if len(w) > len(answer) else min(w, answer)                          # 글자수가 같으면 사전순으로 빠른 것을 등록
        
        return answer

'''
Runtime: 140 ms, faster than 36.82% of Python3 online submissions for Longest Word in Dictionary.
Memory Usage: 14.7 MB, less than 67.11% of Python3 online submissions for Longest Word in Dictionary.
'''

'''
최적 풀이

class Solution(object):
    def longestWord(self, words):
        Trie = lambda: collections.defaultdict(Trie)
        trie = Trie()
        END = True

        for i, word in enumerate(words):
            reduce(dict.__getitem__, word, trie)[END] = i

        stack = trie.values()
        ans = ""
        while stack:
            cur = stack.pop()
            if END in cur:
                word = words[cur[END]]
                if len(word) > len(ans) or len(word) == len(ans) and word < ans:
                    ans = word
                stack.extend([cur[letter] for letter in cur if letter != END])

        return ans

Tries(prefix tree)를 이용하여 깊이우선탐색하는 알고리즘이라는데, Tries에 대한 공부가 필요해보인다.

'''