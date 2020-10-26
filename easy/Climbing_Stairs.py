'''
70.
Climbing Stairs
https://leetcode.com/problems/climbing-stairs/
'''

class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        
        first = 1
        second = 2
        
        for _ in range(3, n + 1):
            third = first + second
            first = second
            second = third
            
        return third
        

'''
Runtime: 28 ms, faster than 73.21% of Python3 online submissions for Climbing Stairs.
Memory Usage: 14.1 MB, less than 99.99% of Python3 online submissions for Climbing Stairs.
'''

'''
여담

전개하는 경우의 수는 피보나치처럼 커지는 패턴을 갖고 있어서
이 문제는 사실상 피보나치 수를 구현하는 것과 같았다.
그래서 처음엔 피보나치를 재귀법으로 구현을 했는데, n이 커지면 커질수록 스택에 쌓이는 양이 커져서 런타임 에러가 떴다.
그래서 반복법으로 바꿔서 구현을 했다.
공식 솔루션에는 이 반복법(O(n))보다 더 짧은 시간 복잡도 log(N)를 가지는 두 가지 방법을 소개하고 있는데,
첫 번째는 Binets Method로 피보나치 수들을 행렬에다 넣고 [1, 1][1, 0]을 곱해서 전개하는 방식으로 풀이한다.
두 번째는 피보나치 공식을 이용한 것으로 풀이 과정은 간단하지만 공식을 외워야한다.

'''