'''
278.
First Bad Version
https://leetcode.com/problems/first-bad-version/
'''
def isBadVersion(version):
    return ('The isBadVersion API is already defined for you.')
    

class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        left = 1
        right = n
        while left < right:
            middle = (left + right) // 2
            if isBadVersion(middle):
                right = middle
            else:
                left = middle + 1
        
        return right

'''
Runtime: 24 ms, faster than 88.98% of Python3 online submissions for First Bad Version.
Memory Usage: 14.3 MB, less than 28.71% of Python3 online submissions for First Bad Version.
'''

'''
여담

binary search로 접근하면 쉽게 풀 수 있는 문제다.

'''