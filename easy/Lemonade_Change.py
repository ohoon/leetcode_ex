'''
860.
Lemonade Change
https://leetcode.com/problems/lemonade-change/
'''

class Solution:
    def lemonadeChange(self, bills: list(int)) -> bool:
        wallet = {5: 0, 10: 0, 20: 0}
        for bill in bills:
            if bill == 5:               # 5달러는 그대로 wallet에 저장
                wallet[5] += 1
                continue
            
            if bill == 10:
                if wallet[5] == 0:      # 10달러는 5달러를 거슬러줘야하는데 없으면 False
                    return False
                
                wallet[5] -= 1
                wallet[10] += 1
                continue
            
            if bill == 20:              # 20달러는 10 + 5달러로 주거나 5 + 5 + 5 달러로 주는 방법이 있음
                if wallet[10] > 0 and wallet[5] > 0:
                    wallet[10] -= 1
                    wallet[5] -= 1
                    wallet[20] += 1
                    continue
                
                if wallet[5] >= 3:
                    wallet[5] -= 3
                    wallet[20] += 1
                    continue
                
                return False
        
        return True

'''
Runtime: 128 ms, faster than 97.42% of Python3 online submissions for Lemonade Change.
Memory Usage: 14.3 MB, less than 94.84% of Python3 online submissions for Lemonade Change.
'''


'''
여담

생각해보니 문제 풀이만 생각하면 굳이 20달러 개수를 셀 필요는 없었던 것 같다.

'''