'''
501.
Find Mode in Binary Search Tree
https://leetcode.com/problems/find-mode-in-binary-search-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from collections import Counter

class Solution:
    def findMode(self, root: TreeNode) -> list(int):                    # 배열로 정리된 노드들을 Counter 모듈로 최다 빈도 노드를 구해 반환
        counter = Counter(self.treeToList(root))
        if not counter:
            return []
        
        max_freq = max(counter.values())
        
        return list(filter(lambda x: counter[x] == max_freq, counter))
    
    def treeToList(self, root: TreeNode) -> list(int):                  # 트리에 있는 노드들을 배열에 정리하는 함수
        if not root:
            return []
        
        return [root.val] + self.treeToList(root.left) + self.treeToList(root.right)

'''
Runtime: 60 ms, faster than 32.89% of Python3 online submissions for Find Mode in Binary Search Tree.
Memory Usage: 18.5 MB, less than 8.55% of Python3 online submissions for Find Mode in Binary Search Tree.
'''