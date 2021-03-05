'''
937.
Reorder Data in Log Files
https://leetcode.com/problems/reorder-data-in-log-files/
'''

class Solution:
    def reorderLogFiles(self, logs: list(str)) -> list(str):
        def customKey(log: str):
            log_split = log.split()
            if log_split[-1].isnumeric():       # digit-logs
                return (log_split[-1].isnumeric(), None, None)          # 입력된 순서대로
            else:                               # letter-logs
                return (log_split[-1].isnumeric(), log_split[1:], log_split[0])     # 식별자를 제외한 문자들로 1차적 sort, 그 다음 식별자로 2차적 sort
            
        return sorted(logs, key=customKey)

'''
Runtime: 32 ms, faster than 89.61% of Python3 online submissions for Reorder Data in Log Files.
Memory Usage: 14.5 MB, less than 10.70% of Python3 online submissions for Reorder Data in Log Files.
'''

'''
여담

sort 함수의 custom key에 대해서 공부할 수 있게 되는 좋은 문제라고 생각함
적당한 난이도에 깔끔한 코드가 나오는 문제라 기분좋게 풀 수 있었다.

'''