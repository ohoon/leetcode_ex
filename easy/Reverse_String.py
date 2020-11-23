'''
344.
Reverse String
https://leetcode.com/problems/reverse-string/
'''

class Solution:
    def reverseString(self, s: list(str)) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        for i in range(len(s) // 2):
            j = -(i + 1)                # 뒤에서 (i+1)번째 인덱스
            s[i], s[j] = s[j], s[i]

'''
Runtime: 184 ms, faster than 96.52% of Python3 online submissions for Reverse String.
Memory Usage: 18.5 MB, less than 48.44% of Python3 online submissions for Reverse String.
'''