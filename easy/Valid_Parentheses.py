'''
20.
Valid Parentheses
https://leetcode.com/problems/valid-parentheses/
'''

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        
        for x in s:
            if (x == '('):      # 여는 괄호가 나오면 닫는 괄호를 스택에 삽입
                stack.append(')')
                continue
            
            if (x == '{'):
                stack.append('}')
                continue
                
            if (x == '['):
                stack.append(']')
                continue
            
            if (not stack or x != stack.pop()):     # x가 여는 괄호가 아니면 스택에서 하나를 pop해 가져와 맞는지 비교, 아니면 False 반환 또는 스택이 비어있으면 False 반환
                return False
        else:       # 모든 괄호가 문제 없다면 True 반환, stack에 아직 괄호 닫을게 남아 있으면 False 반환
            return True if not stack else False

'''
Runtime: 24 ms, faster than 94.32% of Python3 online submissions for Valid Parentheses.
Memory Usage: 14 MB, less than 100.00% of Python3 online submissions for Valid Parentheses.
'''