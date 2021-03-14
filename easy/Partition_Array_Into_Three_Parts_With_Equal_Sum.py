'''
1013.
Partition Array Into Three Parts With Equal Sum
https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
'''

from functools import reduce

class Solution:
    def canThreePartsEqualSum(self, arr: list(int)) -> bool:
        self.index = 0                              # reduce를 하면서 x의 인덱스를 추론하기 위함
        
        def reducer(acc: int, x: int):              # custom reducer
            nxt = acc + x                           # 현재까지의 누적 값 nxt
            if nxt in hash_map:
                hash_map[nxt].append(self.index)
            else:
                hash_map[nxt] = [self.index]
            
            self.index += 1
            return nxt
        
        hash_map = {}
        all_sum = reduce(reducer, arr, 0)           # arr을 탐색하며 각각 누적값을 hash_map에 등록
        if all_sum % 3 > 0:                         # 총 합이 3으로 나누어지지 않으면 False 반환
            return False
        
        if all_sum == 0:                            # 총 합이 0이면 hash_map[0]이 3개 이상인지 확인
            return len(hash_map[0]) >= 3
        
        first = all_sum // 3                        # 3파트로 나누기 위한 조건으로 총 합의 1/3, 2/3인 지점이 존재해야함
        second = first * 2
        
        return first in hash_map and second in hash_map and hash_map[first][0] < hash_map[second][-1]

'''
Runtime: 380 ms, faster than 15.89% of Python3 online submissions for Partition Array Into Three Parts With Equal Sum.
Memory Usage: 21.3 MB, less than 18.10% of Python3 online submissions for Partition Array Into Three Parts With Equal Sum.
'''

'''
다른 사람의 풀이

class Solution:
    def canThreePartsEqualSum(self, A: List[int]) -> bool:
    	S = sum(A)
    	if S % 3 != 0: return False
    	g, C, p = S//3, 0, 0
    	for a in A[:-1]:
    		C += a
    		if C == g:
    			if p == 1: return True
    			C, p = 0, 1
    	return False

나름 reduce와 해시맵을 사용해서 알고리즘을 최적화했다고 생각했는데, 생각보다 속도가 잘 안나와서 다른 풀이법이 궁금했다.
크게 보면 나의 풀이 방식과는 같지만 불필요하게 hash_map과 reduce를 사용하지 않고 two-pass(처음 sum할 때 한번, 1/3지점을 찾을 때 한번)로 해결한 모습이다.

'''