'''
169.
Majority Element
https://leetcode.com/problems/majority-element/
'''

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()     # 오름차순 정렬
        return nums[len(nums) // 2]     # 배열의 가운뎃 값은 무조건 절반 이상 차지한 숫자가 됨

'''
Runtime: 152 ms, faster than 94.75% of Python3 online submissions for Majority Element.
Memory Usage: 15.5 MB, less than 100.00% of Python3 online submissions for Majority Element.
'''

'''
다른 풀이

from collections import Counter

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        numbers = Counter(nums)
        length = len(nums)
        for n in numbers.items():
            if n[1] >= length / 2:
                return n[0]

제출한 풀이는 정렬 함수를 이용한 풀이로, 해당 숫자가 배열 절반보다 많다면 정렬했을 때 가운데는 무조건 그 숫자가 있을 것이라는 성질을 이용한 풀이법이다.
그 외로 풀이한 방법은 Counter 함수를 이용해서 해시맵으로 푸는 풀이법이다.
각 숫자들이 나타난 빈도 수를 기록해서 전체 길이 반 이상이면 리턴하는 간단한 풀이다.

'''