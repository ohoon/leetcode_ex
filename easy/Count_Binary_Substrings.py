'''
696.
Count Binary Substrings
https://leetcode.com/problems/count-binary-substrings/
'''

class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        length = len(s)
        prev = 0        # 이전에 연속된 0 또는 1의 개수
        count = 1       # 현재 연속된 0 또는 1의 개수
        answer = 0
        if length < 2:
            return 0
        
        for i in range(1, length):
            if s[i] != s[i-1]:                      # 불연속구간에
                if prev > 0:                        # 처음 불연속구간을 만난 경우를 제외하기 위함
                    answer += min(prev, count)      # 00111 -> min(2, 3) = 2 -> 0011, 01 두 가지 경우가 있음
                
                prev = count
                count = 1
                continue
            
            count += 1
        
        answer += min(prev, count)                  # 남겨진 마지막 구간의 경우의 수를 계산
        
        return answer

'''
Runtime: 160 ms, faster than 68.79% of Python3 online submissions for Count Binary Substrings.
Memory Usage: 14.7 MB, less than 29.61% of Python3 online submissions for Count Binary Substrings.
'''