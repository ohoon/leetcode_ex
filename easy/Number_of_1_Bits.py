'''
191.
Number of 1 Bits
https://leetcode.com/problems/number-of-1-bits/
'''

class Solution:
    hash_map = {}
    
    def hammingWeight(self, n: int) -> int:
        answer = 0
        while n:
            byte = n & 0xff     # 바이트 단위로 쪼개서 작업
            n >>= 8
            if byte in self.hash_map:       # 해당 바이트가 이미 연산되었으면 해시 테이블에서 결과값 불러옴
                answer += self.hash_map[byte]
                continue
            
            # 해시 테이블에 없는 바이트인 경우
            temp = byte
            result = 0
            while temp:
                result += temp % 2
                temp //= 2
            
            self.hash_map[byte] = result        # 결과값 해시 테이블에 등록
            answer += result
        
        return answer

'''
Runtime: 24 ms, faster than 93.71% of Python3 online submissions for Number of 1 Bits.
Memory Usage: 14.1 MB, less than 99.98% of Python3 online submissions for Number of 1 Bits.
'''