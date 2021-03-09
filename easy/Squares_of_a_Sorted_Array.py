'''
977.
Squares of a Sorted Array
https://leetcode.com/problems/squares-of-a-sorted-array/
'''

class Solution:
    def sortedSquares(self, nums: list(int)) -> list(int):
        answer = []
        plus, minus = [], []
        for x in nums:              # 양수, 음수 구별하여 append
            if x >= 0:
                plus.append(x)
            else:
                minus.append(x)
        
        minus = minus[::-1]         # 음수는 reverse하여 내림차순으로 되도록 정렬
        
        plus_len, minus_len = len(plus), len(minus)
        plus_cur, minus_cur = 0, 0
        while plus_cur < plus_len or minus_cur < minus_len:         # plus와 minus를 작은 수끼리 비교하면서 절대값이 작은 값을 제곱하여 answer에 append
            if plus_cur >= plus_len:                                # plus의 커서가 index를 초과할 경우 minus의 요소 추가
                answer.append(minus[minus_cur] ** 2)
                minus_cur += 1
                continue
            
            if minus_cur >= minus_len:                              # minus의 커서가 index를 초과할 경우 plus의 요소 추가
                answer.append(plus[plus_cur] ** 2)
                plus_cur += 1
                continue
                
            if plus[plus_cur] >= abs(minus[minus_cur]):             # 절대값 비교하여 작은 값 제곱하여 append
                answer.append(minus[minus_cur] ** 2)
                minus_cur += 1
            else:
                answer.append(plus[plus_cur] ** 2)
                plus_cur += 1
        
        return answer

'''
Runtime: 248 ms, faster than 37.73% of Python3 online submissions for Squares of a Sorted Array.
Memory Usage: 16.3 MB, less than 9.43% of Python3 online submissions for Squares of a Sorted Array.
'''

'''
heapq를 이용한 풀이

from heapq import heappush, heappop

class Solution:
    def sortedSquares(self, nums: list(int)) -> list(int):
        heap = []
        for n in nums:
            heappush(heap, n ** 2)
        
        return [heappop(heap) for _ in range(len(heap))]

heapq의 최소 힙 성질때문에 제곱하여 들어간 요소는 자동으로 오름차순으로 정렬되어 삽입됨
코드가 간단하지만 O(N)보다는 시간복잡도가 더 걸리는 단점이 있음

'''