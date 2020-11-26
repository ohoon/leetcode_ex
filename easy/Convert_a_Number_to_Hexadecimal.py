'''
405.
Convert a Number to Hexadecimal
https://leetcode.com/problems/convert-a-number-to-hexadecimal/
'''

class Solution:
    def toHex(self, num: int) -> str:
        hash_map = {0: '0', 1: '1', 2: '2', 3: '3', 4: '4', 5: '5', 6: '6', 7: '7', 8: '8', 9: '9',
                   10: 'a', 11: 'b', 12: 'c', 13: 'd', 14: 'e', 15: 'f'}
        answer = ''
        for _ in range(8):          # 32byte의 정수 기준이므로 16진수 기준 8번의 계산이 필요함
            answer = hash_map[num % 16] + answer            # num이 음수인 경우에도 %와 // 연산은 2의 보수와 동일하게 값이 나옴
            num //= 16
            if num == 0:
                break
        
        return answer

'''
Runtime: 28 ms, faster than 69.79% of Python3 online submissions for Convert a Number to Hexadecimal.
Memory Usage: 14.4 MB, less than 7.78% of Python3 online submissions for Convert a Number to Hexadecimal.
'''