'''
728.
Self Dividing Numbers
https://leetcode.com/problems/self-dividing-numbers/
'''

class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> list(int):
        answer = []
        for num in range(left, right + 1):
            for x in str(num):
                digit = int(x)
                if digit == 0 or num % digit != 0:          # 숫자에 0이 포함되거나 각 자리수로 나누어떨어지지 않으면 다음 숫자로
                    break
            else:                                           # break되지 않고 숫자가 모두 각 자리수에 나누어떨어지면 answer에 추가
                answer.append(num)
        
        return answer

'''
Runtime: 44 ms, faster than 76.85% of Python3 online submissions for Self Dividing Numbers.
Memory Usage: 14.1 MB, less than 67.71% of Python3 online submissions for Self Dividing Numbers.
'''