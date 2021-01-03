'''
788.
Rotated Digits
https://leetcode.com/problems/rotated-digits/
'''

class Solution:
    def rotatedDigits(self, N: int) -> int:
        mirror = '0125689'                  # 180도 회전해도 숫자가 되는 것들
        good = '2569'                       # mirror면서 자신이 아닌 다른 숫자가 되는 것들
        answer = 0
        for num in range(1, N + 1):
            isGood = False                  # good이 1개 이상 들어있나?
            for digit in str(num):
                if digit not in mirror:     # mirror아닌게 있으면 180도 회전하면 숫자가 안되므로 break
                    break
                
                if digit in good:           # good이 1개 이상있어야 180도 회전하면 다른 숫자가 됨
                    isGood = True
            else:
                if isGood:
                    answer += 1
        
        return answer

'''
Runtime: 56 ms, faster than 87.22% of Python3 online submissions for Rotated Digits.
Memory Usage: 14.4 MB, less than 18.45% of Python3 online submissions for Rotated Digits.
'''

'''
다른 사람의 풀이

def rotatedDigits(self, N: int) -> int:
        count = 0
        for d in range(1, N+1):
            d = str(d)
            if '3' in d or '4' in d or '7' in d:
                continue
            if '2' in d or '5' in d or '6' in d or '9' in d:
                count+=1
        return count

사실 위처럼 풀이하면 코드가 더욱 간단해진다.

'''