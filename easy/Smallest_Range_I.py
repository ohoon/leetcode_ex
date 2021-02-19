'''
908.
Smallest Range I
https://leetcode.com/problems/smallest-range-i/
'''

class Solution:
    def smallestRangeI(self, A: list(int), K: int) -> int:
        minNum, maxNum = A[0], A[0]
        for a in A:                         # A의 요소에서 최소값, 최대값을 추출
            if a < minNum:
                minNum = a
                continue
                
            if a > maxNum:
                maxNum = a
                continue
        
        return max((maxNum - K) - (minNum + K), 0)      # 최대값에서 K만큼 뺀 것과 최소값에서 K만큼 더한 것의 차이를 반환. 0보다 작으면 maxNum에서 (K-n)만큼 빼면되므로 0을 반환

'''
Runtime: 104 ms, faster than 96.50% of Python3 online submissions for Smallest Range I.
Memory Usage: 15.5 MB, less than 6.79% of Python3 online submissions for Smallest Range I.
'''