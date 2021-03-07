'''
961.
N-Repeated Element in Size 2N Array
https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
'''

from collections import Counter

class Solution:
    def repeatedNTimes(self, A: list(int)) -> int:
        counter = Counter(A)            # 각 숫자의 개수를 가진 해시 테이블
        for a in counter:
            if counter[a] > 1:          # 숫자가 1개 이상 나오면 반환
                return a

'''
Runtime: 212 ms, faster than 49.52% of Python3 online submissions for N-Repeated Element in Size 2N Array.
Memory Usage: 15.7 MB, less than 35.60% of Python3 online submissions for N-Repeated Element in Size 2N Array.
'''

'''
다른 풀이

class Solution:
    def repeatedNTimes(self, A: List[int]) -> int:
        for k in range(1, 4):
            for i in range(len(A) - k):
                if A[i] == A[i+k]:
                    return A[i]

Counter 함수를 이용하면 손쉽게 풀 수 있는 문제지만 다른 풀이를 찾아보니 Moore's Voting Algorithm으로 풀이하는 방식이 있어 가져왔다.
과반수 이상이 나온 수 X는 전체 N개 중에 N/2개이므로 요소 2개에 1개 꼴인 셈이다. 따라서 각 요소를 2개씩 묶으면 1개가 도출된다고 생각하고
4개씩 묶으면 X가 2개 포함되어 있을 것이라 예상할 수 있다. 모든 경우가 그런 것은 아니니 4개 씩 묶으면서 묶음 안에 2개가 존재하는 수가 있으면 그 수가 X라고 도출하는 방식이다.
예를 들어 A = [1, 5, 2, 3, 5, 4, 5, 5]라면 첫 묶음 [1, 5, 2, 3]에는 발견되지 않고 다음 묶음 [5, 2, 3, 5]에서 5가 2번 나오는 것을 알 수 있다.
따로 저장 공간을 만들지 않고 one-pass로 찾을 수 있기 때문에 보다 효율적이다.

'''