'''
559.
Maximum Depth of N-ary Tree
https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
'''

class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children

class Solution:
    def maxDepth(self, root: 'Node') -> int:
        if not root:
            return 0
        
        if not root.children:
            return 1
        
        return max(self.maxDepth(child) for child in root.children) + 1         # 단말 노드부터 루트 노드까지 1씩 증가하며 깊이의 최댓값을 반환

'''
Runtime: 40 ms, faster than 90.89% of Python3 online submissions for Maximum Depth of N-ary Tree.
Memory Usage: 16 MB, less than 23.92% of Python3 online submissions for Maximum Depth of N-ary Tree.
'''