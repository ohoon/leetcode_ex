'''
448.
Find All Numbers Disappeared in an Array
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
'''

class Solution:
    def findDisappearedNumbers(self, nums: list(int)) -> list(int):
        for n in nums:
            cur = n                 # 요소가 가리키는 숫자
            while cur > 0:
                temp = nums[cur-1]  # (cur-1)번째 요소의 값을 0으로 하고 원래 값을 cur로 하여 싸이클이 될 때까지 반복
                nums[cur-1] = 0
                cur = temp
                
        return [(i + 1) for i in range(len(nums)) if nums[i] > 0]       # 0이 아닌 요소들의 인덱스를 추출

'''
Runtime: 360 ms, faster than 47.74% of Python3 online submissions for Find All Numbers Disappeared in an Array.
Memory Usage: 20.9 MB, less than 99.07% of Python3 online submissions for Find All Numbers Disappeared in an Array.
'''

'''
다른 사람의 풀이

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        lenn = len(nums)
        for i in range(lenn):
            val = abs(nums[i]) - 1
            nums[val] = abs(nums[val]) * -1
        res = []
        for i in range(lenn):
            if nums[i] > 0:
                res.append(i+1)
        return res

나는 탐색된 요소를 0으로 바꿨지만
이 사람은 탐색된 요소를 음수로 바꿔서 탐색되었는지 확인하고 그 수의 절대값으로 다음 요소를 추적하였다.
나는 one-pass라고 보긴 어려워 시간복잡도가 조금 높지만 절대값을 활용하면 one-pass가 가능하여 효율이 높다고 볼 수 있다.

'''