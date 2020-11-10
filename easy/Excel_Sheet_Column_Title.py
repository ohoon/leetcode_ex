'''
168.
Excel Sheet Column Title
https://leetcode.com/problems/excel-sheet-column-title/
'''

class Solution:
    def convertToTitle(self, n: int) -> str:
        string = ""
        hash_map = {}
        for i, x in enumerate(range(ord('A'), ord('Z') + 1)):       # 알파벳 해시맵
            hash_map[i+1] = chr(x)
        
        while n > 0:
            string = hash_map[(n - 1) % 26 + 1] + string
            n = (n - 1) // 26
        
        return string

'''
Runtime: 20 ms, faster than 98.15% of Python3 online submissions for Excel Sheet Column Title.
Memory Usage: 14 MB, less than 100.00% of Python3 online submissions for Excel Sheet Column Title.
'''