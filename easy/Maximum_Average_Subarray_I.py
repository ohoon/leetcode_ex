'''
643.
Maximum Average Subarray I
https://leetcode.com/problems/average-of-levels-in-binary-tree/
'''

class Solution:
    def findMaxAverage(self, nums: list(int), k: int) -> float:
        max_sum = sum(nums[:k])
        s = max_sum
        for i in range(1, len(nums) - k + 1):           # Sliding-Window 기법
            s += nums[i+k-1] - nums[i-1]                # 기존에 구한 합에서 새롭게 추가되는 요소를 더하고 제거되는 요소를 뺌
            max_sum = max(s, max_sum)
            
        return max_sum / k                              # 최대 합을 k로 나누어 최대 평균치 반환

'''
Runtime: 820 ms, faster than 69.19% of Python3 online submissions for Maximum Average Subarray I.
Memory Usage: 18.1 MB, less than 5.25% of Python3 online submissions for Maximum Average Subarray I.
'''