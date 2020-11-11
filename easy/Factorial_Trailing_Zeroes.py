'''
172.
Factorial Trailing Zeroes
https://leetcode.com/problems/factorial-trailing-zeroes/
'''

class Solution:
    def trailingZeroes(self, n: int) -> int:
        answer = 0
        while n > 0:
            n //= 5
            answer += n
        
        return answer

'''
Runtime: 28 ms, faster than 85.71% of Python3 online submissions for Factorial Trailing Zeroes.
Memory Usage: 14 MB, less than 100.00% of Python3 online submissions for Factorial Trailing Zeroes.
'''

'''
여담

우선 다른 솔루션이나 힌트없이 짧은 시간 안에 풀어서 만족!
풀이 방법은 다음과 같다.
n!의 끝부분 0의 개수는 결국 10을 얼마나 곱했느냐와 같다.
이 말은 n!을 소인수분해할 때, 10의 개수 = 2 x 5의 개수를 찾으면 되는데
팩토리얼 연산을 하면서 아무래도 2의 배수가 5의 배수보다 훨씬 많기 때문에 우리는 5의 배수만 고려하면 된다.
n이 15라면 15까지의 숫자 중에 5의 배수는 5, 10, 15이다. 수식으로 간단히 표현하면 15 // 5이다.
n이 105라면 5, 10, ..., 95, 100, 105인데 여기서 조심할 것이 25는 5의 제곱이므로 5가 2번 곱해진다.
따라서 105일 경우 5의 개수는 105 // 5 + 105 // 5 // 5와 같다.
이런 식으로 5의 개수를 집계해서 반환해주면 되는 문제다.

'''