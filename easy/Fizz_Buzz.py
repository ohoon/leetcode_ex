'''
412.
Fizz Buzz
https://leetcode.com/problems/fizz-buzz/
'''

class Solution:
    def fizzBuzz(self, n: int) -> list(str):
        answer = []
        for i in range(1, n + 1):
            if i % 15 == 0:
                answer.append('FizzBuzz')
                continue
                
            if i % 3 == 0:
                answer.append('Fizz')
                continue

            if i % 5 == 0:
                answer.append('Buzz')
                continue
            
            answer.append(str(i))
        
        return answer

'''
Runtime: 40 ms, faster than 73.73% of Python3 online submissions for Fizz Buzz.
Memory Usage: 15 MB, less than 60.76% of Python3 online submissions for Fizz Buzz.
'''