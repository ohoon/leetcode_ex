'''
1030.
Matrix Cells in Distance Order
https://leetcode.com/problems/matrix-cells-in-distance-order/
'''

class Solution:
    def allCellsDistOrder(self, R: int, C: int, r0: int, c0: int) -> list(list(int)):
        cells = [[r, c] for c in range(C) for r in range(R)]
        return sorted(cells, key=lambda x: abs(r0 - x[0]) + abs(c0 - x[1]))     # [r0, c0]과 각 row, col의 거리를 key로 하여 sort

'''
Runtime: 156 ms, faster than 82.38% of Python3 online submissions for Matrix Cells in Distance Order.
Memory Usage: 16.3 MB, less than 56.98% of Python3 online submissions for Matrix Cells in Distance Order.
'''
