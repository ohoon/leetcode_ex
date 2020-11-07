'''
122.
Best Time to Buy and Sell Stock II
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
'''

class Solution:
    def maxProfit(self, prices: list(int)) -> int:
        length = len(prices)
        maxProfit = 0
        for i in range(1, length):
            if prices[i] > prices[i-1]:     # 가격이 상승한 지점
                maxProfit += prices[i] - prices[i-1]    # 상승한 만큼 maxProfit에 증가
        
        return maxProfit

'''
Runtime: 52 ms, faster than 95.85% of Python3 online submissions for Best Time to Buy and Sell Stock II.
Memory Usage: 14.8 MB, less than 100.00% of Python3 online submissions for Best Time to Buy and Sell Stock II.
'''

'''
여담

처음에는 동적계획법으로 시도했다.
하지만 1단계 문제와 마찬가지로 시간초과가 떴다.
그래서 어떤식으로 구현해야할까 계속 고민하다가 정말 떠오르는 방법이 없어서 솔루션을 봤음
솔루션의 최적 풀이법은 다음과 같다.
가격의 흐름을 꺾은선 그래프로 나타내면 각 peak와 valley부분의 차이들의 합은 최고 peak와 최저 valley의 차이보다 무조건 같거나 크다는 성질을 알 수 있다.
그리고 각 점들 사이의 차이 합은 점들이 이루고 있는 peak와 valley부분의 차이봐 무조건 같거나 크다는 성질 또한 알 수 있다.
따라서 최고 이익을 구하기 위해서는 모든 점들 사이의 차이 합을 구하면 된다.
말로 설명하기는 이해하기 어려운데 릿코드에서 직접 솔루션의 그림을 보면 이해하기 쉬울 것이다.

'''