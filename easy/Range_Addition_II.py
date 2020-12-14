'''
598.
Range Addition II
https://leetcode.com/problems/range-addition-ii/
'''

class Solution:
    def maxCount(self, m: int, n: int, ops: list(list(int))) -> int:
        if not ops:
            return m * n
        
        # (0, 0)부터 (x[0], x[1])의 범위에서 1씩 누적되므로 가장 누적되는 값은 x[0]와 x[1] 각각의 최솟값의 범위임
        min_a, min_b = m, n
        for x in ops:
            if x[0] < min_a:
                min_a = x[0]
            
            if x[1] < min_b:
                min_b = x[1]
        
        return min_a * min_b

'''
Runtime: 68 ms, faster than 69.98% of Python3 online submissions for Range Addition II.
Memory Usage: 16.3 MB, less than 9.69% of Python3 online submissions for Range Addition II.
'''