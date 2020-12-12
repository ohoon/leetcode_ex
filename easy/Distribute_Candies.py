'''
575.
Distribute Candies
https://leetcode.com/problems/distribute-candies/
'''

class Solution:
    def distributeCandies(self, candyType: list(int)) -> int:
        return min(len(set(candyType)), len(candyType) // 2)

'''
Runtime: 796 ms, faster than 50.37% of Python3 online submissions for Distribute Candies.
Memory Usage: 16.4 MB, less than 18.99% of Python3 online submissions for Distribute Candies.
'''