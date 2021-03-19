'''
1047.
Remove All Adjacent Duplicates In String
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
'''

class Solution:
    def removeDuplicates(self, S: str) -> str:
        stack = []
        for s in S:
            if not stack:           # 스택에 아무것도 없으면 무조건 append
                stack.append(s)
                continue
            
            if s == stack[-1]:      # 연속으로 같은 문자가 오면 pop
                stack.pop()
                continue
            
            stack.append(s)
        
        return "".join(stack)

'''
Runtime: 68 ms, faster than 79.01% of Python3 online submissions for Remove All Adjacent Duplicates In String.
Memory Usage: 14.6 MB, less than 59.29% of Python3 online submissions for Remove All Adjacent Duplicates In String.
'''
