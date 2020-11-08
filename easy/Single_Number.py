'''
136.
Single Number
https://leetcode.com/problems/single-number/
'''

from collections import Counter

class Solution:
    def singleNumber(self, nums: list(int)) -> int:
        for key, value in Counter(nums).items():
            if value == 1:
                return key

'''
Runtime: 120 ms, faster than 65.31% of Python3 online submissions for Single Number.
Memory Usage: 16.6 MB, less than 45.72% of Python3 online submissions for Single Number.
'''

'''
최적 풀이

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        a = 0
        for i in nums:
            a ^= i
        return a

Follow up을 보면 여분의 메모리 공간을 사용하지 않는 O(N) 시간복잡도 알고리즘을 짜라고 되어있었다.
하지만 배열이나 딕셔너리 없이 구현하는 방법이 떠오르지 않아서 일단 딕셔너리로 풀어보고
메모리 공간을 사용하지 않는 솔루션을 찾아봤다.
위의 코드는 XOR 성질을 이용해서 A xor B xor A 이면 A xor A는 0이므로 0 xor B = B, 즉 twice가 아닌 요소가 출력된다.

'''