'''
661.
Image Smoother
https://leetcode.com/problems/image-smoother/
'''

from copy import deepcopy

class Solution:
    def imageSmoother(self, M: list(list(int))) -> list(list(int)):
        row = len(M)
        col = len(M[0])
        N = deepcopy(M)             # 배열 속의 값'만' 복사
        for i in range(row):
            for j in range(col):
                total = 0           # 주변 요소 값의 합
                count = 1           # 주변 요소 개수. 자기 자신은 무조건 들어가므로 1
                if i > 0:           # 첫번째 행일 때 i-1 연산은 제외
                    if j > 0:
                        total += M[i-1][j-1]
                        count += 1
                    
                    if j < col - 1:
                        total += M[i-1][j+1]
                        count += 1
                    
                    total += M[i-1][j]
                    count += 1
                
                if i < row - 1:     # 마지막 행일 때 i+1 연산은 제외
                    if j > 0:
                        total += M[i+1][j-1]
                        count += 1
                    
                    if j < col - 1:
                        total += M[i+1][j+1]
                        count += 1
                    
                    total += M[i+1][j]
                    count += 1

                # 그 외 중간 행들 연산
                if j > 0:
                    total += M[i][j-1]
                    count += 1

                if j < col - 1:
                    total += M[i][j+1]
                    count += 1

                total += M[i][j]
                N[i][j] = total // count        # 평균 값 계산해서 N에 대입
        
        return N

'''
Runtime: 580 ms, faster than 87.10% of Python3 online submissions for Image Smoother.
Memory Usage: 15.1 MB, less than 14.89% of Python3 online submissions for Image Smoother.
'''