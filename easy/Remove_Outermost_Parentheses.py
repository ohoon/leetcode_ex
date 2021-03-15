'''
1021.
Remove Outermost Parentheses
https://leetcode.com/problems/remove-outermost-parentheses/
'''

class Solution:
    def removeOuterParentheses(self, S: str) -> str:
        stack = []
        answer = ""
        for s in S:
            if s == '(':                # '('의 경우
                if len(stack) > 0:      # 가장 outer인 '('을 제외한 '('은 answer에 추가
                    answer += '('
                
                stack.append(s)
            else:                       # ')'의 경우
                if len(stack) > 1:		# 가장 outer인 '('을 닫는 경우를 제외한 ')'은 answer에 추가
                    answer += ')'
                
                stack.pop()
        
        return answer

'''
Runtime: 36 ms, faster than 82.49% of Python3 online submissions for Remove Outermost Parentheses.
Memory Usage: 14.2 MB, less than 95.06% of Python3 online submissions for Remove Outermost Parentheses.
'''
