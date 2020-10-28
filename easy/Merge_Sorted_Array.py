'''
88.
Merge Sorted Array
https://leetcode.com/problems/merge-sorted-array/
'''

from collections import deque

class Solution:
    def merge(self, nums1: list(int), m: int, nums2: list(int), n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if n > 0:
            nums2 = deque(nums2)
            temp = deque(nums1[:m])     # 밀림 현상을 해결하기 위해 temp에 밀린 숫자들을 저장해서 비교에 사용
            
            for i in range(m + n):
                if m == 0:
                    nums1[i] = nums2.popleft()
                    continue

                if (not nums2) and temp:
                    nums1[i] = temp.popleft()
                    continue

                if (not temp) and nums2:
                    nums1[i] = nums2.popleft()
                    continue

                nums1[i] = nums2.popleft() if temp[0] > nums2[0] else temp.popleft()

'''
Runtime: 24 ms, faster than 99.55% of Python3 online submissions for Merge Sorted Array.
Memory Usage: 14.2 MB, less than 100.00% of Python3 online submissions for Merge Sorted Array.
'''

'''
다른 사람의 풀이

def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
	writeIndex = m + n - 1
	m, n = m-1, n-1
	
	while n>=0 and m>=0:
		if nums1[m] > nums2[n]:
			nums1[writeIndex] = nums1[m]
			#nums1[m] = float("-inf")           We don't need to change this value because m will be pointing to m-1
			m -= 1
		else:
			nums1[writeIndex] = nums2[n]
			n -= 1
		writeIndex -= 1
		
	if n>-1:
		nums1[0:n+1] = nums2[0:n+1]

애초에 뒤에서부터 접근하면 깔끔하게 해결되는 문제인데,
앞에서 접근하는 방법을 택해서 nums1의 값들이 밀리는 현상으로 코드가 복잡해지는 아주 간단하고 초보적인 실수를 범했다.
기존 merge sort 알고리즘을 생각해서 편견이 생긴 것 같다..

'''