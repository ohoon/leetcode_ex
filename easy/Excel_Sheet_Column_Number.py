'''
171.
Excel Sheet Column Number
https://leetcode.com/problems/excel-sheet-column-number/
'''

class Solution:
    def titleToNumber(self, s: str) -> int:
        hash_map = {}
        col = 0
        for i, ascii_code in enumerate(range(ord('A'), ord('Z') + 1)):      # 해시맵에 알파벳별로 전환 값 저장
            hash_map[chr(ascii_code)] = i + 1
        
        for x in s:
            col = col * 26 + hash_map[x]        # 자리수가 늘어날 때마다 이전 값에 26을 곱해주고 더함
        
        return col

'''
Runtime: 32 ms, faster than 63.69% of Python3 online submissions for Excel Sheet Column Number.
Memory Usage: 14.1 MB, less than 99.97% of Python3 online submissions for Excel Sheet Column Number.
'''