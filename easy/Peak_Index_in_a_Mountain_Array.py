'''
852.
Peak Index in a Mountain Array
https://leetcode.com/problems/peak-index-in-a-mountain-array/
'''

class Solution:
    def peakIndexInMountainArray(self, arr: list(int)) -> int:
        left, right = 0, len(arr) - 1
        while left < right:                     # 2진 탐색법
            mid = (left + right) // 2
            if arr[mid] > arr[mid+1]:           # 하강하는 부분이면 왼쪽으로 재탐색
                if arr[mid] > arr[mid-1]:       # 꼭지점 조건까지 만족하면 바로 return
                    return mid
                
                right = mid
                continue
            else:                               # 상승하는 부분이면 오른쪽으로 재탐색
                left = mid + 1
                continue
        
        return left

'''
Runtime: 72 ms, faster than 83.82% of Python3 online submissions for Peak Index in a Mountain Array.
Memory Usage: 15.3 MB, less than 57.96% of Python3 online submissions for Peak Index in a Mountain Array.
'''