'''
989.
Add to Array-Form of Integer
https://leetcode.com/problems/add-to-array-form-of-integer/
'''

class Solution:
    def addToArrayForm(self, A: list(int), K: int) -> list(int):
        cur = len(A) - 1					# A의 일의 자리부터 접근
        while K > 0 and cur > -1:
            K, inc = divmod(K, 10)			# K의 일의 자리 수 inc를 가져와 A[cur]에 더함
            A[cur] += inc
            carry, A[cur] = divmod(A[cur], 10)	# A[cur]이 10이상이 되면 일의 자리를 제외한 수를 K에 더하여 다음 연산에 씀
            K += carry
            cur -= 1
        
        if K > 0:								# K가 남아있으면 K만큼 A 앞에 배열을 추가해줌
            A = [int(k) for k in str(K)] + A
            
        return A

'''
Runtime: 260 ms, faster than 96.92% of Python3 online submissions for Add to Array-Form of Integer.
Memory Usage: 14.9 MB, less than 93.14% of Python3 online submissions for Add to Array-Form of Integer.
'''

'''
다른 풀이

class Solution:
    def addToArrayForm(self, A: List[int], K: int) -> List[int]:
        return [x for x in str(int("".join(map(str, A))) + K)]

간단하게 구현할 수 있는 방법인데 예상한 것 보다 속도가 꽤 나와서 놀랐다.
그래도 불필요한 map, join, str 연산을 거치므로 위의 풀이보다 2배 정도 느린 것으로 나온다.

'''
