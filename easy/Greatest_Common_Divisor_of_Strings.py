'''
1071.
Greatest Common Divisor of Strings
https://leetcode.com/problems/greatest-common-divisor-of-strings/
'''

class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        len1, len2 = len(str1), len(str2)
        if len2 > len1:                     # str1 >= str2이 되도록 정렬
            str1, str2 = str2, str1
            len1, len2 = len2, len1
        
        if len1 == len2:                            # 글자수가 동일하면 두 문자가 같은지 확인
            return str1 if str1 == str2 else ""
        
        if str1[:len2] != str2:                     # 0부터 len2만큼 str1에서 파싱하여 str2와 같은지 확인
            return ""
        
        return self.gcdOfStrings(str1[len2:], str2)     # 위에서 파싱하여 비교한 것을 제외한 문자들과 str2을 재귀적으로 반복 비교

'''
Runtime: 28 ms, faster than 90.07% of Python3 online submissions for Greatest Common Divisor of Strings.
Memory Usage: 14.4 MB, less than 33.81% of Python3 online submissions for Greatest Common Divisor of Strings.
'''

'''
여담

순수하게 내 힘으로 푼 것이 아니라 힌트를 보고 풀었기 때문에 아쉽다
count함수를 사용하지 않고 풀이할 방법이 뭐가 있을까 계속 생각해보다가 감이 안와서 힌트를 보고
재귀적으로 풀이해야 한다는 것을 알았다.
string 문제에서 재귀법을 사용하는 것은 처음이라 아예 감을 못잡고 있었다.
어떤 문제든지 재귀적으로 풀이할 수 있다는 것을 계속 기억하고 내 것으로 만들어야 겠다.

'''
