'''
303.
Range Sum Query - Immutable
https://leetcode.com/problems/nim-game/
'''

class NumArray:

    def __init__(self, nums: list(int)):
        self.arr = [0]
        acc = 0
        for x in nums:              # 각 숫자까지의 누적 값으로 배열을 생성
            acc += x
            self.arr.append(acc)

    def sumRange(self, i: int, j: int) -> int:
        return self.arr[j+1] - self.arr[i]          # 0 ~ j까지의 누적값 - 0 ~ (i-1)까지의 누적값 = i ~ j까지의 누적값

'''
Runtime: 60 ms, faster than 99.77% of Python3 online submissions for Range Sum Query - Immutable.
Memory Usage: 17.7 MB, less than 15.41% of Python3 online submissions for Range Sum Query - Immutable.
'''