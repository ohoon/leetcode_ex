'''
350.
Intersection of Two Arrays II
https://leetcode.com/problems/intersection-of-two-arrays-ii/
'''

from collections import Counter

class Solution:
    def intersect(self, nums1: list(int), nums2: list(int)) -> list(int):
        nums1, nums2 = Counter(nums1), Counter(nums2)       # {숫자: 숫자의 개수} 형태로 2개의 해시맵 생성
        answer = []
        for x in set(nums1.keys()) & set(nums2.keys()):     # set처럼 교집합을 구하고, 두 해시맵의 숫자 개수 최솟값만큼 넣어줌
            answer += [x] * min(nums1[x], nums2[x])
        
        return answer

'''
Runtime: 44 ms, faster than 79.50% of Python3 online submissions for Intersection of Two Arrays II.
Memory Usage: 14.4 MB, less than 23.27% of Python3 online submissions for Intersection of Two Arrays II.
'''