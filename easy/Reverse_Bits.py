'''
190.
Reverse Bits
https://leetcode.com/problems/reverse-bits/
'''

class Solution:
    hash_map = {}
    
    def reverseBits(self, n: int) -> int:
        if n in self.hash_map:
            return self.hash_map[n]
        
        num = n
        bits = ""
        for _ in range(32):
            bits += str(n % 2)
            n //= 2
        
        self.hash_map[num] = int(bits, 2)
        
        return self.hash_map[num]

'''
Runtime: 36 ms, faster than 26.29% of Python3 online submissions for Reverse Bits.
Memory Usage: 14 MB, less than 100.00% of Python3 online submissions for Reverse Bits.
'''

'''
다른 풀이

class Solution:
    def reverseBits(self, n):
        ret, power = 0, 24
        cache = dict()
        while n:
            ret += self.reverseByte(n & 0xff, cache) << power
            n = n >> 8
            power -= 8
        return ret

    def reverseByte(self, byte, cache):
        if byte not in cache:
            cache[byte] = (byte * 0x0202020202 & 0x010884422010) % 1023
        return cache[byte]

Follow up의 요구사항은 다음과 같다.
'이 함수가 여러번 호출되었을 경우를 고려해서 최적화하라.'
그래서 해시 테이블을 만들어서 입력값 n이 들어오면 n이 해시테이블에 있는지 확인하고 있으면
이미 연산되어 저장된 값을 반환시켜주도록 코딩했다.
하지만 바이트 단위로 나눌 생각은 하지 못했던 것 같다.
다른 풀이에는 비트연산을 사용해서 바이트 단위인 0xff로 나눠서 해시테이블에 저장해서 관리한다.
그리고 비트를 뒤집는 것을 반복문이 아닌 Bit Twiddling Hacks by Sean Eron Anderson 방법을 사용했다.
그 외에도 mask and shift 방법 등이 있지만 복잡해서 곰곰히 더 생각해봐야겠다.

'''