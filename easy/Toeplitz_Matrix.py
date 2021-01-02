'''
766.
Toeplitz Matrix
https://leetcode.com/problems/toeplitz-matrix/
'''

class Solution:
    def isToeplitzMatrix(self, matrix: list(list(int))) -> bool:
        prev = matrix[0][:-1]
        for i in range(1, len(matrix)):             # 지금 행의 마지막 요소를 제외한 값들이 다음 행의 첫 요소 다음의 값들이 됨
            if matrix[i][1:] != prev:
                return False
            
            prev = matrix[i][:-1]
        
        return True

'''
Runtime: 76 ms, faster than 96.46% of Python3 online submissions for Toeplitz Matrix.
Memory Usage: 14.1 MB, less than 94.66% of Python3 online submissions for Toeplitz Matrix.
'''