'''
905.
Sort Array By Parity
https://leetcode.com/problems/sort-array-by-parity/
'''

class Solution:
    def sortArrayByParity(self, A: list(int)) -> list(int):
        return sorted(A, key=lambda x: x % 2)           # sorting key를 x % 2로 설정하여 각 요소를 짝수 -> 홀수 순으로 오름차순 정렬

'''
Runtime: 76 ms, faster than 84.81% of Python3 online submissions for Sort Array By Parity.
Memory Usage: 14.8 MB, less than 94.28% of Python3 online submissions for Sort Array By Parity.
'''

'''
다른 풀이

class Solution(object):
    def sortArrayByParity(self, A):
        i, j = 0, len(A) - 1
        while i < j:
            if A[i] % 2 > A[j] % 2:
                A[i], A[j] = A[j], A[i]

            if A[i] % 2 == 0: i += 1
            if A[j] % 2 == 1: j -= 1

        return A

i, j 2개의 커서를 이용하여 A 내부에서 요소들의 교환이 이루어지는 풀이법이다.
처음과 끝에서 서로 비교해가면서 짝수는 앞쪽으로, 홀수는 뒤쪽으로 가도록 swap 하고 그에 따라 포인터를 움직이며 진행된다.
sort하는 풀이보다는 다소 복잡하지만 별도의 공간을 사용하지 않고 O(N * log N)의 시간복잡도를 가지는 sort 함수보다 효율적이라고 생각됨

'''