'''
228.
Summary Ranges
https://leetcode.com/problems/summary-ranges/
'''

class Solution:
    def summaryRanges(self, nums: list(int)) -> list(str):
        if not nums:
            return nums
        
        start, end = nums[0], nums[0] + 1       # 연속되는 숫자의 시작 요소와 끝 요소
        answer = []
        for i in range(1, len(nums)):
            if nums[i] != end:          # 연속되지 않으면
                end = nums[i-1]         # 이전 요소까지 범위로 설정하기 위해 end 변경
                answer.append((str(start) + '->' + str(end)) if start < end else str(start))        # start와 end가 같으면 그 요소만, 아니면 '시작 요소 -> 끝 요소'를 answer에 추가
                start, end = nums[i], nums[i] + 1       # 시작, 끝 요소를 새로 발급
                continue
            
            end += 1        # 다음 연속적인 수
        
        answer.append((str(start)) if start == nums[-1] else str(start) + '->' + str(end - 1))      # for문이 끝나고 end처리
        
        return answer

'''
Runtime: 28 ms, faster than 68.65% of Python3 online submissions for Summary Ranges.
Memory Usage: 14.1 MB, less than 27.29% of Python3 online submissions for Summary Ranges.
'''