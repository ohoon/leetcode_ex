'''
617.
Merge Two Binary Trees
https://leetcode.com/problems/merge-two-binary-trees/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def mergeTrees(self, t1: TreeNode, t2: TreeNode) -> TreeNode:
        if not t1 and not t2:           # 둘 다 빈 노드면 NoneType 반환
            return None
        
        if not t1 or not t2:            # 겹치지 않는다면 존재하는 노드만 반환, 하위노드의 경우도 마찬가지이므로 볼 필요 없음
            return t1 or t2
        
                                        # 두 노드가 겹친다면 값을 합하고 하위 노드로 전개
        t1.val += t2.val
        t1.left = self.mergeTrees(t1.left, t2.left)
        t1.right = self.mergeTrees(t1.right, t2.right)
        
        return t1

'''
Runtime: 76 ms, faster than 98.99% of Python3 online submissions for Merge Two Binary Trees.
Memory Usage: 15.5 MB, less than 29.61% of Python3 online submissions for Merge Two Binary Trees.
'''