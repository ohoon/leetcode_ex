'''
292.
Nim Game
https://leetcode.com/problems/nim-game/
'''

class Solution:
    def canWinNim(self, n: int) -> bool:
        return n % 4        # 4의 배수는 첫 번째 플레이어가 1 ~ 3 중에 무엇을 외치든 두 번째 플레이어가 외칠 수 있기 때문

'''
Runtime: 24 ms, faster than 88.41% of Python3 online submissions for Nim Game.
Memory Usage: 14.3 MB, less than 23.27% of Python3 online submissions for Nim Game.
'''