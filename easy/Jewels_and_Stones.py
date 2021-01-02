'''
771.
Jewels and Stones
https://leetcode.com/problems/jewels-and-stones/
'''

class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        return len([s for s in stones if s in jewels])      # jewels에 있는 원소만 stones에서 추출하여 개수 반환

'''
Runtime: 28 ms, faster than 82.22% of Python3 online submissions for Jewels and Stones.
Memory Usage: 14.2 MB, less than 35.87% of Python3 online submissions for Jewels and Stones.
'''