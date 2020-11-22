'''
342.
Power of Four
https://leetcode.com/problems/power-of-four/
'''

class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        return n & (n - 1) == 0 and (n - 1) % 3 == 0

'''
Runtime: 32 ms, faster than 52.06% of Python3 online submissions for Power of Four.
Memory Usage: 14.3 MB, less than 5.05% of Python3 online submissions for Power of Four.
'''

'''
풀이 설명

n과 n-1을 and 비트연산해서 0인지 확인하면 n이 2의 제곱수인지 알 수 있게 된다.
이제 n이 4의 제곱에만 해당하는 수인지 가려내면 되는데, 이 때 사용하는 공식이 다음과 같다.
n = 4 ^ i라면 n = (3 + 1) ^ i 이고, 괄호을 풀어내면 n = 3 ^ i + ... + a * 3 + 1 이라고 표현할 수 있다.
양 변에 -1을 취하면 n - 1 = 3 ^ i + ... + a * 3 이고, 3으로 묶으면 n - 1 = 3 * (3 ^ (i-1) + ... + a) 이다.
즉, n - 1은 3의 배수인 것을 알 수 있으므로 (n - 1) % 3 == 0인지 추가로 검사하면 4의 제곱수인지 확인이 가능하다.

'''