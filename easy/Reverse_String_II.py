'''
541.
Reverse String II
https://leetcode.com/problems/reverse-string-ii/
'''

class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        s_list = list(s)
        length = len(s_list)
        for i in range(0, length, 2 * k):           # 2k 간격마다 reverse하는 것을 반복
            s_list[i:i+k] = s_list[i:i+k][::-1]

        return "".join(s_list)

'''
Runtime: 28 ms, faster than 86.23% of Python3 online submissions for Reverse String II.
Memory Usage: 14.3 MB, less than 37.31% of Python3 online submissions for Reverse String II.
'''