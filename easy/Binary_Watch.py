'''
401.
Binary Watch
https://leetcode.com/problems/binary-watch/
'''

from itertools import combinations

class Solution:
    def readBinaryWatch(self, num: int) -> list(str):
        h_bit = [1, 2, 4, 8]
        m_bit = [1, 2, 4, 8, 16, 32]
        answer = []
        for i in range(num + 1):        # 시간에서 i개의 비트를 사용
            j = num - i                 # 분에서 나머지 비트를 사용
            for h_comb in combinations(h_bit, i):       # i개의 비트로 만들 수 있는 시간들
                hour = sum(h_comb)
                if hour > 11:           # 12시를 넘어가면 건너띔
                    continue
                    
                for m_comb in combinations(m_bit, j):       # 나머지 비트로 만들 수 있는 분들
                    minute = sum(m_comb)
                    if minute > 59:         # 60분을 넘어가면 건너띔
                        continue
                        
                    answer.append(str(hour) + ':' + str(minute).zfill(2))       # 양식에 맞게 가공해서 answer에 삽입
        
        return answer

'''
Runtime: 32 ms, faster than 63.94% of Python3 online submissions for Binary Watch.
Memory Usage: 14.2 MB, less than 14.84% of Python3 online submissions for Binary Watch.
'''

'''
다른 풀이

class Solution:
    def readBinaryWatch(self, n: int) -> List[str]:
    	return [str(h)+':'+'0'*(m<10)+str(m) for h in range(12) for m in range(60) if (bin(m)+bin(h)).count('1') == n]

이 풀이는 나의 풀이처럼 combination을 계산해서 n개의 비트를 고르는 모든 경우를 계산하는 것이 아니라
0~11까지의 시간과 0~59까지의 분을 가진 시간의 비트 개수가 n인 것을 찾아 출력하는 방법이다.

'''