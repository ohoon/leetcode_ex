'''
121.
Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
'''

class Solution:
    def maxProfit(self, prices: list(int)) -> int:
        if not prices:
            return 0
        
        length = len(prices)
        maxProfit = 0
        minimum = prices[0]
        for i in range(length):
            if prices[i] < minimum:     # 최솟값인지 검사
                minimum = prices[i]
                continue
                
            profit = prices[i] - minimum        # 현재 값 - 최솟 값 => 이익
            if profit > maxProfit:          # 최대 이익인지 검사
                maxProfit = profit
        
        return maxProfit

'''
Runtime: 56 ms, faster than 91.88% of Python3 online submissions for Best Time to Buy and Sell Stock.
Memory Usage: 15 MB, less than 99.99% of Python3 online submissions for Best Time to Buy and Sell Stock.
'''

'''
여담

처음엔 max() min()을 사용해서 풀이했는데,
max min 자체가 O(N)인데다가 이 함수를 매 숫자마다 반복하니까 O(N*N)의 시간복잡도가 걸렸다.
그래서 minimum이라는 변수에 최솟값을 할당해서 비교하는 로직으로 바꿔서 풀이했더니 빠른 시간내에 잘되었다.

'''