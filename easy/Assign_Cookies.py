'''
455.
Assign Cookies
https://leetcode.com/problems/assign-cookies/
'''

class Solution:
    def findContentChildren(self, g: list(int), s: list(int)) -> int:
        g.sort()                    # 아이와 쿠키 리스트 오름차순 정렬
        s.sort()
        content = 0
        while g and s:
            if g[-1] <= s[-1]:      # 아이가 쿠키에 만족하면 pop
                content += 1
                s.pop()
            
            g.pop()                 # 다음 아이로
        
        return content

'''
Runtime: 144 ms, faster than 98.25% of Python3 online submissions for Assign Cookies.
Memory Usage: 15.7 MB, less than 87.00% of Python3 online submissions for Assign Cookies.
'''