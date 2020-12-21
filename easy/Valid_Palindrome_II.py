'''
680.
Valid Palindrome II
https://leetcode.com/problems/valid-palindrome-ii/
'''

class Solution:
    def validPalindrome(self, s: str) -> bool:
        left, right = 0, len(s) - 1
        while left < right:
            if s[left] != s[right]:             # 대칭하지 않으면
                case1 = s[left+1:right+1]       # 왼쪽 부분을 제거한 나머지 부분
                case2 = s[left:right]           # 오른쪽 부분을 제거한 나머지 부분
                
                return case1 == case1[::-1] or case2 == case2[::-1]     # 각 케이스 별로 대칭인지 확인하고 하나라도 대칭하면 True
            
            left += 1
            right -= 1
            
        return True         # 대칭하지 않은 부분이 없으면 가운데 문자를 제거하면 되므로 True

'''
Runtime: 100 ms, faster than 79.51% of Python3 online submissions for Valid Palindrome II.
Memory Usage: 14.7 MB, less than 13.53% of Python3 online submissions for Valid Palindrome II.
'''