'''
1022.
Sum of Root To Leaf Binary Numbers
https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sumRootToLeaf(self, root: TreeNode) -> int:
        self.answer = 0
        
        if not root.left and not root.right:
            return root.val
        
        def calcRootToLeaf(root: TreeNode, acc: int):           # DFS 탐색
            if not root:
                return
            
            num = acc * 2 + root.val                            # 이전까지의 누적 값 acc를 왼쪽으로 시프트하고 root.val을 삽입
            if not root.left and not root.right:                # leaf 노드인 경우에 현재까지의 누적 값 num을 answer에 증가시키고 탐색 중단
                self.answer += num
                return
            
            calcRootToLeaf(root.left, num)                      # 왼쪽 서브 트리로 탐색 계속
            calcRootToLeaf(root.right, num)                     # 오른쪽 서브 트리로 탐색 계속
        
        calcRootToLeaf(root.left, root.val)                     # 루트 노드의 좌측 서브 트리 탐색
        calcRootToLeaf(root.right, root.val)                    # 루트 노드의 우측 서브 트리 탐색
        
        return self.answer

'''
Runtime: 36 ms, faster than 77.61% of Python3 online submissions for Sum of Root To Leaf Binary Numbers.
Memory Usage: 14.5 MB, less than 70.64% of Python3 online submissions for Sum of Root To Leaf Binary Numbers.
'''