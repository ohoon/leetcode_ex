'''
819.
Most Common Word
https://leetcode.com/problems/most-common-word/
'''

class Solution:
    def mostCommonWord(self, paragraph: str, banned: list(str)) -> str:
        hash_map = {}
        word = ''
        for x in paragraph:
            x = x.lower()
            if x.isalpha():                     # 알파벳이면 word에 더하여 저장
                word += x
                continue
                
            if len(word) > 0:                   # 알파벳이 아닌 문자가 오면 지금까지 저장한 word를 해시맵에 저장
                if word not in banned:
                    if word in hash_map:
                        hash_map[word] += 1
                    else:
                        hash_map[word] = 1
                
                word = ''
        
        if len(word) > 0:                       # paragraph 맨 끝의 단어 처리
            if word not in banned:
                if word in hash_map:
                    hash_map[word] += 1
                else:
                    hash_map[word] = 1
        
        return sorted(hash_map.items(), key=lambda x: x[1], reverse=True)[0][0]         # 횟수가 많은 것대로 정렬하고 빈도수가 제일 높은 단어 반환

'''
Runtime: 40 ms, faster than 26.71% of Python3 online submissions for Most Common Word.
Memory Usage: 14.2 MB, less than 85.18% of Python3 online submissions for Most Common Word.
'''