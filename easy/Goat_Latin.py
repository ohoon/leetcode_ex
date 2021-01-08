'''
824.
Goat Latin
https://leetcode.com/problems/goat-latin/
'''

class Solution:
    def toGoatLatin(self, S: str) -> str:
        answer = []
        latin, vowel = 'ma', 'aeiou'
        for word in S.split():
            if word[0].lower() not in vowel:            # 자음으로 시작하면 첫 문자를 뒤로
                word = word[1:] + word[0]
            
            latin += 'a'
            answer.append(word + latin)                 # 음메소리를 끝에 붙여줌
        
        return " ".join(answer)

'''
Runtime: 28 ms, faster than 80.73% of Python3 online submissions for Goat Latin.
Memory Usage: 14.1 MB, less than 69.71% of Python3 online submissions for Goat Latin.
'''