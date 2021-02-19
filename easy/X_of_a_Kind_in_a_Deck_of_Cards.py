'''
914.
X of a Kind in a Deck of Cards
https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
'''

from collections import Counter

class Solution:
    def hasGroupsSizeX(self, deck: list(int)) -> bool:
        counter = Counter(deck).values()                # deck의 각 요소들의 빈도
        minimum = min(counter)                          # 가장 낮은 빈도를 구하여 공약수를 계산하는데 사용
        
        if minimum == 1:
            return False
        
        for i in range(minimum, 1, -1):
            if all(c % i == 0 for c in counter):        # 공약수 g가 존재하면 g의 길이를 가진 group으로 나누는 것이 가능
                return True
        
        return False

'''
Runtime: 132 ms, faster than 81.57% of Python3 online submissions for X of a Kind in a Deck of Cards.
Memory Usage: 14.5 MB, less than 80.60% of Python3 online submissions for X of a Kind in a Deck of Cards.
'''