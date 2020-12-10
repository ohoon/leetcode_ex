'''
566.
Reshape the Matrix
https://leetcode.com/problems/reshape-the-matrix/
'''

class Solution:
    def matrixReshape(self, nums: list(list(int)), r: int, c: int) -> list(list(int)):
        answer = []
        temp = []
        for row in nums:
            for n in row:
                temp.append(n)
                if len(temp) == c:              # c개의 열을 가지는 한 행이 완성되면
                    answer.append(temp)         # 행 추가
                    temp = []
        
        return answer if len(answer) == r and len(temp) == 0 else nums

'''
Runtime: 92 ms, faster than 87.51% of Python3 online submissions for Reshape the Matrix.
Memory Usage: 15.1 MB, less than 41.11% of Python3 online submissions for Reshape the Matrix.
'''