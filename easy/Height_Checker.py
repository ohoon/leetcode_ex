'''
1051.
Height Checker
https://leetcode.com/problems/height-checker/
'''

class Solution:
    def heightChecker(self, heights: list(int)) -> int:
        answer = 0
        for x, y in zip(heights, sorted(heights)):      # 정렬한 것과 안한 것을 zip로 비교
            if x - y != 0:                              # 같지 않으면 answer을 1 증가
                answer += 1
        
        return answer

'''
Runtime: 36 ms, faster than 68.91% of Python3 online submissions for Height Checker.
Memory Usage: 14.1 MB, less than 74.91% of Python3 online submissions for Height Checker.
'''
