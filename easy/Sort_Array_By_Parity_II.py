'''
922.
Sort Array By Parity II
https://leetcode.com/problems/sort-array-by-parity-ii/
'''

class Solution:
    def sortArrayByParityII(self, A: list(int)) -> list(int):
        length = len(A)
        odd, even = 0, 1                        # 교환이 필요한 odd, even 요소의 인덱스
        while odd < length and even < length:
            if A[odd] % 2 == 0:                 # 짝수 자리에 있는 홀수를 찾아 탐색
                odd = odd + 2
                continue
            
            if A[even] % 2 == 1:                # 홀수 자리에 있는 짝수를 찾아 탐색
                even = even + 2
                continue
            
            A[odd], A[even] = A[even], A[odd]   # swap
            odd, even = odd + 2, even + 2
        
        return A

'''
Runtime: 32 ms, faster than 63.07% of Python3 online submissions for Reverse Only Letters.
Memory Usage: 14.3 MB, less than 51.89% of Python3 online submissions for Reverse Only Letters.
'''