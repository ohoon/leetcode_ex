'''
1662.
Check If Two String Arrays are Equivalent
https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
'''

class Solution:
    def arrayStringsAreEqual(self, word1: list(str), word2: list(str)) -> bool:
        return "".join(word1) == "".join(word2)

'''
Runtime: 32 ms, faster than 59.77% of Python3 online submissions for Check If Two String Arrays are Equivalent.
Memory Usage: 14.3 MB, less than 62.58% of Python3 online submissions for Check If Two String Arrays are Equivalent.
'''

'''
다른 사람의 풀이

class Solution:
    def arrayStringsAreEqual(self, word1: List[str], word2: List[str]) -> bool:
        for c1, c2 in zip(self.generate(word1), self.generate(word2)):
            if c1 != c2:
                return False
        return True

    def generate(self, wordlist: List[str]):
        for word in wordlist:
            for char in word:
                yield char
        yield None

제네레이터를 이용한 풀이다.
join으로 합쳐서 비교하는 풀이와 다르게 word1과 word2 중 길이가 짧은 정도에 따라 빠르게 끝날 수 있다.

'''