'''
476.
Number Complement
https://leetcode.com/problems/number-complement/
'''

class Solution:
    def findComplement(self, num: int) -> int:
        for i in range(1, 33):
            mask = 2 ** i               # num과 bit 길이와 같은 수를 알기 위함
            if mask > num:
                return (mask - 1) ^ num         # num과 1111..11(2)를 xor하여 반전시킴

'''
Runtime: 24 ms, faster than 93.06% of Python3 online submissions for Number Complement.
Memory Usage: 14.3 MB, less than 7.60% of Python3 online submissions for Number Complement.
'''