'''
944.
Delete Columns to Make Sorted
https://leetcode.com/problems/delete-columns-to-make-sorted/
'''

class Solution:
    def minDeletionSize(self, strs: list(str)) -> int:
        return len([col for col in zip(*strs) if sorted(col) != list(col)])         # strs의 각 열을 가져와 해당 열 그룹이 정렬 전 후와 다른지 확인, 총 갯수를 구하여 반환

'''
Runtime: 96 ms, faster than 90.03% of Python3 online submissions for Delete Columns to Make Sorted.
Memory Usage: 14.7 MB, less than 70.09% of Python3 online submissions for Delete Columns to Make Sorted.
'''