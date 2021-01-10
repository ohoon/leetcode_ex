'''
832.
Flipping an Image
https://leetcode.com/problems/flipping-an-image/
'''

class Solution:
    def flipAndInvertImage(self, A: list(list(int))) -> list(list(int)):
        return [[1 - x for x in y[::-1]] for y in A]

'''
Runtime: 52 ms, faster than 45.26% of Python3 online submissions for Flipping an Image.
Memory Usage: 14.3 MB, less than 21.30% of Python3 online submissions for Flipping an Image.
'''