'''
461.
Hamming Distance
https://leetcode.com/problems/hamming-distance/
'''

class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        return bin(x ^ y).count('1')

'''
Runtime: 28 ms, faster than 67.34% of Python3 online submissions for Number of Segments in a String.
Memory Usage: 14.1 MB, less than 30.04% of Python3 online submissions for Number of Segments in a String.
'''