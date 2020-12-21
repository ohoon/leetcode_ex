'''
682.
Baseball Game
https://leetcode.com/problems/baseball-game/
'''

class Solution:
    def calPoints(self, ops: list(str)) -> int:
        record = []
        for op in ops:
            if op == 'C':
                record.pop()
                continue
            
            if op == 'D':
                record.append(record[-1] * 2)
                continue
            
            if op == '+':
                record.append(record[-2] + record[-1])
                continue
            
            record.append(int(op))
            
        return sum(record)

'''
Runtime: 36 ms, faster than 86.03% of Python3 online submissions for Baseball Game.
Memory Usage: 14.3 MB, less than 86.84% of Python3 online submissions for Baseball Game.
'''