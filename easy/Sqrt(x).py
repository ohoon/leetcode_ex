'''
69.
Sqrt(x)
https://leetcode.com/problems/sqrtx/
'''

class Solution:
    def mySqrt(self, x: int) -> int:
        left, right = 0, x
        
        if x == 1:
            return x
        
        while left < right:
            mid = (left + right) // 2
            if mid == left:
                break
            
            if mid ** 2 > x:
                right = mid
                continue
            
            if mid ** 2 < x:
                left = mid
                continue
                
            return mid
        
        return left

'''
Runtime: 36 ms, faster than 61.27% of Python3 online submissions for Sqrt(x).
Memory Usage: 14.1 MB, less than 99.97% of Python3 online submissions for Sqrt(x).
'''

'''
여담

math 모듈의 sqrt함수나 ** 0.5를 이용하면 간단하지만
그걸 위해서 낸 문제가 아닌 것을 알고 binary search를 써서 풀이했다.
매끄럽게 코드가 나오진 않아서 좀 아쉽지만 로직 자체는 쉽게 떠올라서 빠르게 풀었다.

'''