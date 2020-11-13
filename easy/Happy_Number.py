'''
202.
Happy Number
https://leetcode.com/problems/happy-number/
'''

class Solution:
    def isHappy(self, n: int) -> bool:
        hash_map = {}
        while n != 1:
            if n in hash_map:       # 싸이클이 발생하면 False 반환
                return False
            
            next_num = 0
            for x in str(n):        # 각 자리수마다 제곱하여 더해줌
                next_num += int(x) ** 2
            
            hash_map[n] = next_num      # n의 연산 결과를 해시맵에 저장
            n = next_num
            
        return True

'''
Runtime: 32 ms, faster than 75.97% of Python3 online submissions for Happy Number.
Memory Usage: 13.9 MB, less than 78.58% of Python3 online submissions for Happy Number.
'''

'''
다른 사람의 풀이

def isHappy(self, n: int) -> bool:
	#20 -> 4 -> 16 -> 37 -> 58 -> 89 -> 145 > 42 -> 20
	slow = self.squared(n)
	fast = self.squared(self.squared(n))

	while slow!=fast and fast!=1:
		slow = self.squared(slow)
		fast = self.squared(self.squared(fast))

	return fast==1

def squared(self, n):
	result = 0
	while n>0:
		last = n%10
		result += last * last
		n = n//10
	return result

싸이클을 확인할 때 해시를 이용하면, O(N)의 공간 복잡도가 필요하지만
위의 풀이처럼 2개의 포인터를 사용하면 O(1)의 공간 복잡도로 풀이가 가능하다.
저번에 풀이했던 연결리스트 싸이클 검사 알고리즘 풀이법과 유사한 느낌이다.

'''