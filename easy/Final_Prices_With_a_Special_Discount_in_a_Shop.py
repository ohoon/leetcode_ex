'''
1475.
Final Prices With a Special Discount in a Shop
https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
'''

class Solution:
    def finalPrices(self, prices: list(int)) -> list(int):
        for i in range(len(prices) - 1):
            for j in range(i + 1, len(prices)):
                if prices[i] >= prices[j]:          # i번쨰 요소 이하인 j번째 요소를 찾으면 감소
                    prices[i] -= prices[j]
                    break

        return prices

'''
Runtime: 56 ms, faster than 37.17% of Python3 online submissions for Final Prices With a Special Discount in a Shop.
Memory Usage: 14.4 MB, less than 51.47% of Python3 online submissions for Final Prices With a Special Discount in a Shop.
'''

'''
다른 풀이

class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        ## RC ##
        ## APPROACH : STACK ##
        ## LOGIC ## 
        ## 1. Use Monotonic Increasing Stack Concept
        ## 2. Main idea is to find the Next Smaller Element in O(N) using #1
        stack = []
        for i, num in enumerate(prices):
            while(stack and prices[stack[-1]] >= num):
                popIndex = stack.pop()
                prices[popIndex] -= num
            stack.append(i)
        return prices

스택을 이용한 풀이다.
prices의 앞에서부터 스택에 인덱스 값을 넣어가며 진행하는데, 이때 스택에 있는 인덱스의 실제 값이 현재 요소 값 이상이면
스택을 pop하고 현재 요소 값만큼 빼는 방식이다.
이렇게 풀이하면 불필요하게 탐색하는 시간을 줄일 수 있기 때문에 효율적이다.

'''