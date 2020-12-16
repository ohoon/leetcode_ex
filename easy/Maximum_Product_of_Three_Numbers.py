'''
628.
Maximum Product of Three Numbers
https://leetcode.com/problems/merge-two-binary-trees/
'''

from functools import reduce

class Solution:
    def maximumProduct(self, nums: list(int)) -> int:
        if len(nums) <= 3:          # nums 요소가 3개 이하면 모든 요소의 곱 반환
            return reduce(lambda res, x: res * x, nums, 1)
        
        nums.sort()                 # 오름차순 정렬
        case1 = reduce(lambda res, x: res * x, nums[:2] + nums[-1:], 1)     # 가장 작은 두 개의 수와 가장 큰 수의 곱
        case2 = reduce(lambda res, x: res * x, nums[-3:], 1)                # 가장 큰 세 개의 수의 곱
        return max(case1, case2)

'''
Runtime: 256 ms, faster than 42.26% of Python3 online submissions for Maximum Product of Three Numbers.
Memory Usage: 15.7 MB, less than 16.78% of Python3 online submissions for Maximum Product of Three Numbers.
'''

'''
다른 사람의 풀이

class Solution:
    def maximumProduct(self, nums: List[int]) -> int:
        smallestTwo = [float('inf')]*2
        largestThree = [float('-inf')]*3
        for num in nums:
            if num <= smallestTwo[0]:
                smallestTwo[0] = num
                smallestTwo.sort(reverse=True)
            if num >= largestThree[0]:
                largestThree[0] = num
                largestThree.sort()
        return max(smallestTwo[0]*smallestTwo[1]*largestThree[2], 
                   largestThree[0]*largestThree[1]*largestThree[2])

nums 전체를 sorting하지 않고 가장 작은 두 수와 가장 큰 세 수를 구해서
가장 큰 세 수의 곱과 가장 작은 두 수와 가장 큰 수의 곱을 비교해서 보다 큰 값을 반환하는 코드다.
nums 전체를 정렬하면 보다 이해하고 코드가 깔끔하지만 sort 알고리즘이 O(n logn)의 시간복잡도를 가지기 때문에 느리다.
따라서 해당 방법이 O(n)으로 더 효율적이라고 생각한다.

'''