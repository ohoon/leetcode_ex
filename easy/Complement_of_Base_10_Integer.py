'''
1009.
Complement of Base 10 Integer
https://leetcode.com/problems/complement-of-base-10-integer/
'''

class Solution:
    def bitwiseComplement(self, N: int) -> int:
        answer = ""
        
        if N == 0:
            return 1
        
        if N == 1:
            return 0
        
        while N > 1:
            N, mod = divmod(N, 2)
            if mod == 0:
                answer = "1" + answer
            else:
                answer = "0" + answer
        
        return int(answer, 2)

'''
Runtime: 28 ms, faster than 85.62% of Python3 online submissions for Complement of Base 10 Integer.
Memory Usage: 14 MB, less than 92.39% of Python3 online submissions for Complement of Base 10 Integer.
'''

'''
다른 사람의 풀이

class Solution:
    def bitwiseComplement(self, N: int) -> int:
        if N==0:
            return 1
        p = int(log2(N))
        mask = int(2**(p+1) - 1)
        return N^mask

1111..111(2)인 마스킹 넘버를 준비해서 XOR연산으로 비트를 반전해서 반환하는 방법이다.
매우 간단하고 속도도 빨라서 뛰어난 풀이법이라고 생각한다.

'''