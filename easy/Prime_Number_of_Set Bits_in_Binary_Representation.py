'''
762.
Prime Number of Set Bits in Binary Representation
https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
'''

from collections import Counter

class Solution:
    def countPrimeSetBits(self, L: int, R: int) -> int:
        def isPrime(number: int) -> bool:                   # prime인지 확인하는 함수
            if number == 1:
                return False
            
            for i in range(int(number ** 0.5), 1, -1):
                if number % i == 0:
                    return False
            
            return True
        
        cur_primes, cur_bits = [1], 1
        primes, answer = [], 0
        L_bit_length = L.bit_length()
        R_bit_length = R.bit_length()
        while True:
            if cur_bits > R_bit_length:
                break
            
            if cur_bits >= L_bit_length:
                primes += cur_primes
            
            cur_primes += [prime + 1 for prime in cur_primes]
            cur_bits += 1
        
        offset = 2 ** (L_bit_length - 1)
        L_index = L - offset
        R_index = R - offset
        counter = Counter(primes[L_index:R_index+1])
        for key, value in counter.items():
            if isPrime(key):
                answer += value
        
        return answer

'''
Runtime: 3204 ms, faster than 5.10% of Python3 online submissions for Prime Number of Set Bits in Binary Representation.
Memory Usage: 37.3 MB, less than 5.71% of Python3 online submissions for Prime Number of Set Bits in Binary Representation.
'''

'''
정석 풀이

class Solution(object):
    def countPrimeSetBits(self, L, R):
        primes = {2, 3, 5, 7, 11, 13, 17, 19}
        return sum(bin(x).count('1') in primes
                   for x in xrange(L, R+1))

R-L의 최대 차이가 10000이라는 제약조건을 못 보고 bin와 prime을 찾는 과정이 오래 걸릴 것 같아서
문제를 엄청 어렵게 생각하다보니 코드도 복잡해지고 시간복잡도도 터무니 없이 높게 나온 것 같다.
R의 최대값이 10의 6승인데, 2의 20승 미만이므로 미리 1 ~ 20까지의 수 중 prime 수를 구해서 비교하는 것으로 prime을 확인했다.

'''