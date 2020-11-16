'''
231.
Power of Two
https://leetcode.com/problems/power-of-two/
'''

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n <= 0:      # 음수 혹은 0은 2의 제곱수가 아님
            return False
    
        while n != 1:       # n이 1이 될 때까지
            if n < 2:       # 2의 음수 제곱수의 경우를 고려해서 2씩 곱해줌
                n *= 2
                continue
                
            if n % 2 != 0:      # 2로 나누어 떨어지지 않으면 제곱수가 아님
                return False
            
            n /= 2      # 1제곱씩 낮춰가며 비교
        
        return True

'''
Runtime: 24 ms, faster than 93.58% of Python3 online submissions for Power of Two.
Memory Usage: 14 MB, less than 83.62% of Python3 online submissions for Power of Two.
'''

'''
다른 사람의 풀이

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return not n&n-1 if n else False

2진수를 비트로 표현할 때, 11010110000와 같은 n에서 n-1의 &연산을 취하면 11010100000이 나올 것이다.
왜냐하면 끝부분의 10000은 1과 나머지 0으로 이루어진 비트들인데 -1을 하면 01111이 될것이다.
10000 & 01111은 즉 00000이고 이것으로 알 수 있는건 1과 나머지 0으로 이루어진 비트들은 -1한 것과 &연산하면 0이 된다는 것이다.
이를 이용해서 n&n-1을 하면 가장 처음 나타나는 1의 상위 비트들만 남는데 이게 0이라면 n은 한 개의 1을 가진 2의 제곱수이라고 추론할 수 있다.
이 법칙을 사용한 문제가 몇번 나왔는데 이렇게 멋지게 써먹을 수 있다는게 놀라웠다.

'''