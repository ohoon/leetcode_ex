'''
1078.
Occurrences After Bigram
https://leetcode.com/problems/occurrences-after-bigram/
'''

class Solution:
    def findOcurrences(self, text: str, first: str, second: str) -> List[str]:
        answer = []
        split_text = text.split(" ")
        for i in range(2, len(split_text)):
            if split_text[i-2] == first and split_text[i-1] == second:          # i-2번째 단어가 first이고 i-1번째 단어가 second이면 i번째 단어를 answer에 추가
                answer.append(split_text[i])
        
        return answer

'''
Runtime: 20 ms, faster than 98.64% of Python3 online submissions for Occurrences After Bigram.
Memory Usage: 14.3 MB, less than 52.86% of Python3 online submissions for Occurrences After Bigram.
'''
