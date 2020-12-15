'''
605.
Can Place Flowers
https://leetcode.com/problems/can-place-flowers/
'''

class Solution:
    def canPlaceFlowers(self, flowerbed: list(int), n: int) -> bool:
        if n == 0:
            return True
        
        length = len(flowerbed)
        for i in range(length):
            if (i == 0 or flowerbed[i-1] == 0) and flowerbed[i] == 0 and (i == length - 1 or flowerbed[i+1] == 0):      # [0, 0, 0]이거나 [0, 0]으로 시작 또는 끝날 경우에 1 삽입
                flowerbed[i] = 1            # 해당 인덱스의 값을 1로 바꾸고 n을 감소
                n -= 1
            
            if n <= 0:                      # 삽입해야할 1의 개수를 만족하면 True
                return True
        
        return False

'''
Runtime: 164 ms, faster than 72.04% of Python3 online submissions for Can Place Flowers.
Memory Usage: 14.6 MB, less than 33.33% of Python3 online submissions for Can Place Flowers.
'''