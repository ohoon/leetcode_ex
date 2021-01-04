'''
804.
Unique Morse Code Words
https://leetcode.com/problems/unique-morse-code-words/
'''

class Solution:
    def uniqueMorseRepresentations(self, words: list(str)) -> int:
        morse = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
                "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        morse_dict = {chr(a): m for a, m in zip(range(97, 124), morse)}         # 위의 모스부호를 각 알파벳에 매칭시켜 딕셔너리를 만듬
        
        return len(set("".join([morse_dict[w] for w in word]) for word in words))       # 만든 딕셔너리를 이용해 문자를 모스부호화하고 set로 중복을 제거하여 길이 반환

'''
Runtime: 36 ms, faster than 57.33% of Python3 online submissions for Unique Morse Code Words.
Memory Usage: 14.5 MB, less than 28.35% of Python3 online submissions for Unique Morse Code Words.
'''