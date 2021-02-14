'''
896.
Monotonic Array
https://leetcode.com/problems/monotonic-array/
'''

class Solution:
    def isMonotonic(self, A: list(int)) -> bool:
        length = len(A)
        if length == 1:
            return True
        
        prev = 0
        for i in range(len(A) - 1):
            diff = A[i] - A[i+1]            # increase/decrease 구분짓기 위함
            if diff == 0:                   # 같은 요소의 반복은 패스
                continue
                
            if diff * prev < 0:             # 지난 기울기와 현재 기울기가 다르면 False 반환
                return False
            
            prev = diff
        
        return True

'''
Runtime: 468 ms, faster than 70.86% of Python3 online submissions for Monotonic Array.
Memory Usage: 20.6 MB, less than 64.70% of Python3 online submissions for Monotonic Array.
'''

'''
다른 풀이

class Solution:
    def isMonotonic(self, A: List[int]) -> bool:
        diff = [A[i] - A[i+1] for i in range(len(A) - 1)]
        return all(x >= 0 for x in diff) or all(x <= 0 for x in diff)

1-pass를 하기 위해서 prev 변수를 두어 곱셈하는 방식으로 검증하였는데,
all을 이용하면 2-pass로 손쉽게 풀이할 수 있다.

'''