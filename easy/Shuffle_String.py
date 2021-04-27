'''
1528.
Shuffle String
https://leetcode.com/problems/shuffle-string/
'''

class Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        answer = [""] * len(s)          # 바뀐 순서 문자열을 저장하기 위한 공간
        for c, i in zip(s, indices):
            answer[i] = c
        
        return ''.join(answer)          # 리스트를 문자열로

'''
Runtime: 52 ms, faster than 77.82% of Python3 online submissions for Shuffle String.
Memory Usage: 14.3 MB, less than 53.80% of Python3 online submissions for Shuffle String.
'''
