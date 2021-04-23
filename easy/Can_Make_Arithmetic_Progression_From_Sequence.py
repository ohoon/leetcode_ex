'''
1502.
Can Make Arithmetic Progression From Sequence
https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
'''

class Solution:
    def canMakeArithmeticProgression(self, arr: list[int]) -> bool:
        arr.sort()              # 오름차순 정렬
        diff = arr[1] - arr[0]  # 차이값
        for i in range(1, len(arr) - 1):
            if arr[i+1] - arr[i] != diff:   # 차이값이 일정하지 않으면 False 반환
                return False

        return True

'''
Runtime: 40 ms, faster than 59.39% of Python3 online submissions for Can Make Arithmetic Progression From Sequence.
Memory Usage: 14.3 MB, less than 88.49% of Python3 online submissions for Can Make Arithmetic Progression From
'''