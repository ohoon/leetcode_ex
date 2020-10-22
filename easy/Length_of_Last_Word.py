'''
58.
Length of Last Word
https://leetcode.com/problems/length-of-last-word/
'''

class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        length = 0
        
        for i in range(len(s) - 1, -1, -1):     # 뒤에서부터 탐색
            if s[i] == ' ' and length > 0:      # 띄어쓰기를 만났고 단어를 지나쳐왔다면 단어 길이 반환
                return length
            
            if s[i] != ' ':                     # 띄어쓰기가 아니면 단어 길이 +1
                length += 1
                
        return length
        

'''
Runtime: 28 ms, faster than 82.78% of Python3 online submissions for Length of Last Word.
Memory Usage: 14.1 MB, less than 100.00% of Python3 online submissions for Length of Last Word.
'''