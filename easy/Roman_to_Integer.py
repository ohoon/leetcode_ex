'''
13.
Roman to Integer
https://leetcode.com/problems/roman-to-integer/
'''

class Solution:
    def romanToInt(self, s: str) -> int:
        symbols = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        result = 0
        prev = ''
        
        for r in s:
            if ( (prev == 'I' and (r == 'V' or r == 'X'))       # IV = 4, IX = 9
                or (prev == 'X' and (r == 'L' or r == 'C'))         # XL = 40, XC = 90
                or (prev == 'C' and (r == 'D' or r == 'M')) ):          # CD = 400, CM = 900
                    result += symbols[r] - 2 * symbols[prev]        # ex: IV -> I + (V - 2I) = V - I = 4
                    prev = r
                    continue
                    
            result += symbols[r]
            prev = r
        
        return result

'''
Runtime: 48 ms, faster than 65.88% of Python3 online submissions for Roman to Integer.
Memory Usage: 14.2 MB, less than 99.99% of Python3 online submissions for Roman to Integer.
'''