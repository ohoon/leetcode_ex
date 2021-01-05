'''
806.
Number of Lines To Write String
https://leetcode.com/problems/number-of-lines-to-write-string/
'''

class Solution:
    def numberOfLines(self, widths: list(int), s: str) -> list(int):
        hash_map = {chr(asc): width for asc, width in zip(range(97, 124), widths)}              # {알파벳: 할당된 길이}
        floor, wide = 1, 0
        for letter in s:
            if wide + hash_map[letter] <= 100:                                                  # 현재까지의 wide가 100이 넘어가면 다음 floor로
                wide += hash_map[letter]
                continue
            
            floor += 1
            wide = hash_map[letter]
        
        return [floor, wide]

'''
Runtime: 32 ms, faster than 60.71% of Python3 online submissions for Number of Lines To Write String.
Memory Usage: 14.2 MB, less than 44.81% of Python3 online submissions for Number of Lines To Write String.
'''