'''
485.
Max Consecutive Ones
https://leetcode.com/problems/max-consecutive-ones/
'''

class Solution:
    def findMaxConsecutiveOnes(self, nums: list(int)) -> int:
        maximum = 0
        cnt = 0             # 0을 만나기 전까지의 1의 개수
        for n in nums:
            if n == 0:
                if cnt > maximum:       # cnt의 최댓값 갱신
                    maximum = cnt
                
                cnt = 0         # cnt 초기화
                continue
            
            cnt += 1
            
        return max(maximum, cnt)

'''
Runtime: 328 ms, faster than 90.89% of Python3 online submissions for Max Consecutive Ones.
Memory Usage: 14.3 MB, less than 88.95% of Python3 online submissions for Max Consecutive Ones.
'''