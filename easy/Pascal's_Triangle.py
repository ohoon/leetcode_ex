'''
118.
Pascal's Triangle
https://leetcode.com/problems/pascals-triangle/
'''

class Solution:
    def generate(self, numRows: int) -> list(list(int)):
        triangle = []
        n = 1
        
        while n <= numRows:
            row = []
            for i in range(n):
                if not triangle or i == 0 or i == n-1:          # 각 행의 처음과 끝은 1로 값 처리
                    row.append(1)
                    continue
                
                row.append(triangle[-1][i-1] + triangle[-1][i])     # 이전 행을 참조하여 값 삽입
            
            triangle.append(row)
            n += 1
            
        return triangle

'''
Runtime: 28 ms, faster than 79.47% of Python3 online submissions for Pascal's Triangle.
Memory Usage: 14.1 MB, less than 100.00% of Python3 online submissions for Pascal's Triangle.
'''