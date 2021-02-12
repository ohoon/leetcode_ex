'''
888.
Fair Candy Swap
https://leetcode.com/problems/fair-candy-swap/
'''

class Solution:
    def fairCandySwap(self, A: list(int), B: list(int)) -> list(int):
        A.sort()
        B.sort()
        curA, curB = 0, 0                   # 2 pointer
        need = (sum(A) - sum(B)) // 2       # 서로 바꿔야 할 숫자 diff값
        
        while True:
            diff = A[curA] - B[curB]        # 각 pointer에 있는 요소들의 diff 값을 구해서 need와 같으면 반환
            
            if diff == need:
                break
            
            if diff < need:                 # diff가 작으면 A의 cursor을 증가
                curA += 1
                continue
            
            if diff > need:                 # diff가 크면 B의 cursor을 증가
                curB += 1
                continue
        
        return [A[curA], B[curB]]

'''
Runtime: 368 ms, faster than 58.43% of Python3 online submissions for Fair Candy Swap.
Memory Usage: 16.3 MB, less than 86.84% of Python3 online submissions for Fair Candy Swap.
'''

'''
다른 풀이

class Solution:
    def fairCandySwap(self, A: List[int], B: List[int]) -> List[int]:
        s = (sum(A) - sum(B)) // 2
        A = set(A)
        
        for n in B:
            if s + n in A:
                return [s + n, n]

A와 B의 합 차이를 이용해서 필요한 요소가 어떤 것인지 추론하는 방법은 맞지만 나의 경우는 불필요하게 sort함수와 while문으로 속도가 많이 느려진 듯하다.
간단하게 A를 set로 바꿔서 중복값을 없애고 (B의 한 요소 + 차이값)인 값이 A에 있는지 확인만 하면 되는 간단하고 효율적인 풀이다.

'''