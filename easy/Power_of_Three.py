'''
326.
Power of Three
https://leetcode.com/problems/power-of-three/
'''

class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        if n <= 0:
            return False
        
        while n != 1:
            if n < 1:
                n *= 3
                continue
            
            if n % 3 != 0:
                return False
            
            n //= 3
            
        return True

'''
Runtime: 76 ms, faster than 60.94% of Python3 online submissions for Power of Three.
Memory Usage: 14.2 MB, less than 16.72% of Python3 online submissions for Power of Three.
'''

'''
여담

2의 제곱인지 확인하는 문제는 비트연산으로 loop없이 풀이가 가능했는데
기본적으로 컴퓨터는 2진수 기반이라 3진수 비트연산을 지원하지 않아 loop없이는 구현이 불가능했다.
그래서 생각을 곰곰히 해보다가 생각난게 math 모듈의 log함수이다.
그렇지만 log를 쓰는 것은 너무 치트같아서 쓰기 싫어서 그냥 무난하게 while문으로 구현했다.

'''