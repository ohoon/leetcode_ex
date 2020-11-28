'''
441.
Arranging Coins
https://leetcode.com/problems/arranging-coins/
'''

class Solution:
    def arrangeCoins(self, n: int) -> int:
        if n > 1:
            sqrt = int((2 * n) ** 0.5)          # (k * (k+1)) // 2 <= n
            if sqrt * (sqrt + 1) <= 2 * n:
                return sqrt
            
            return sqrt - 1
        
        return n

'''
Runtime: 28 ms, faster than 67.34% of Python3 online submissions for Number of Segments in a String.
Memory Usage: 14.1 MB, less than 30.04% of Python3 online submissions for Number of Segments in a String.
'''

'''
다른 풀이

class Solution:
    def arrangeCoins(self, n: int) -> int:
        return (int)((2 * n + 0.25)**0.5 - 0.5)

나의 풀이처럼 수학 공식으로 접근해서 풀이한 것이다.
방정식을 제대로 풀지 못한 내 코드와는 다르게 정확한 값이 나오도록 만들었음
방정식의 해를 구할 수 있었는데 그 생각을 못한게 아쉽다.

class Solution:
    def arrangeCoins(self, n: int) -> int:
        left, right = 0, n
        while left <= right:
            k = (right + left) // 2
            curr = k * (k + 1) // 2
            if curr == n:
                return k
            if n < curr:
                right = k - 1
            else:
                left = k + 1
        return right

2진 탐색을 이용한 방법으로, 물론 수학 공식에 비해서는 약간의 시간이 더 걸리지만 멋진 풀이 방법이라고 생각한다.
 
'''