'''
830.
Positions of Large Groups
https://leetcode.com/problems/positions-of-large-groups/
'''

class Solution:
    def largeGroupPositions(self, s: str) -> list(list(int)):
        answer = []
        prev, count = 0, 1                  # 해당 숫자가 처음 나온 인덱스, 해당 숫자 개수
        for i in range(1, len(s)):
            if s[prev] != s[i]:
                if count >= 3:              # 3번 이상 나온 숫자면 answer에 추가
                    answer.append([prev, i-1])
                
                prev, count = i , 1
                continue
            
            count += 1
        
        if count >= 3:                      # for문이 끝나기 전 마지막 부분 처리
            answer.append([prev, i])
        
        return answer

'''
Runtime: 36 ms, faster than 79.34% of Python3 online submissions for Positions of Large Groups.
Memory Usage: 14.5 MB, less than 6.62% of Python3 online submissions for Positions of Large Groups.
'''