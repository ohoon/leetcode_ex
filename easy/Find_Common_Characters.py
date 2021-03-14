'''
1002.
Find Common Characters
https://leetcode.com/problems/find-common-characters/
'''

from collections import Counter

class Solution:
    def commonChars(self, A: list(str)) -> list(str):
        common = Counter(A[0])				# 공통 단어들과 그 단어의 개수가 들어 있는 해시 테이블
        for i in range(1, len(A)):
            counter = Counter(A[i])
            common -= common - counter		# 먼저 공통 단어 셋에서 현재 단어 셋을 빼는 것으로 공통적인 문자들이 제외된 셋을 구하고, 이것을 공통 단어 셋에서 빼는 것으로 공통적인 문자들만 존재하는 셋을 구하여 갱신함
        
        return [c for c in common for _ in range(common[c])]

'''
Runtime: 56 ms, faster than 40.05% of Python3 online submissions for Find Common Characters.
Memory Usage: 14.3 MB, less than 60.28% of Python3 online submissions for Find Common Characters.
'''

'''
다른 풀이

class Solution:
    def commonChars(self, A: List[str]) -> List[str]:
		result = []
        for c in set(A[0]):
            count = A[0].count(c)
            occurences = 1
            for i in range(1,len(A)):
                if c in A[i]:
                    count = min(count,A[i].count(c))
                    occurences += 1
                else:
                    break
            if occurences == len(A):
                for i in range(count):
                    result.append(c)
                    
        return result
        
Counter함수 대신에 count 내장 함수를 이용해서 풀이한 방법이다.
첫번째 단어의 각 문자를 다른 단어와 비교해서 해당 문자가 몇개 들어있는지 확인하고, 최솟값을 차례대로 대치하면서 전체적으로 공통적인 문자를 도출할 수 있다.

'''
