'''
867.
Transpose Matrix
https://leetcode.com/problems/transpose-matrix/
'''

class Solution:
    def transpose(self, A: list(list(int))) -> list(list(int)):
        return [[A[r][c] for r in range(len(A))] for c in range(len(A[0]))]     # 행방향으로 배열 요소를 넣어서 반환

'''
Runtime: 72 ms, faster than 70.92% of Python3 online submissions for Transpose Matrix.
Memory Usage: 14.9 MB, less than 34.51% of Python3 online submissions for Transpose Matrix.
'''

'''
다른 풀이

return [list(row) for row in zip(*A)]

A의 요소를 zip으로 병렬적으로 처리하여 row당 col을 삽입하여 반환하는 방식

'''