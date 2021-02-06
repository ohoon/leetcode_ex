'''
872.
Leaf-Similar Trees
https://leetcode.com/problems/leaf-similar-trees/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def leafSimilar(self, root1: TreeNode, root2: TreeNode) -> bool:
        def leafArray(root: TreeNode):
            if not root.left and not root.right:        # 단말 노드면 자신의 val을 반환
                return [root.val]
            
            left, right = [], []
            
            if root.left:
                left = leafArray(root.left)
            
            if root.right:
                right = leafArray(root.right)
                
            return left + right                         # 양측의 단말 노드들을 불러오며 재귀
        
        if not root1 or not root2:
            return root1 == root2
        
        return leafArray(root1) == leafArray(root2)     # root1와 root2의 단말 노드 값들의 배열이 같으면 True 다르면 False

'''
Runtime: 32 ms, faster than 73.34% of Python3 online submissions for Leaf-Similar Trees.
Memory Usage: 14.4 MB, less than 45.72% of Python3 online submissions for Leaf-Similar Trees.
'''

'''
다른 풀이

class Solution:
    def leafSimilar(self, root1, root2):
        def dfs(node):
            if node:
                if not node.left and not node.right:
                    yield node.val
                yield from dfs(node.left)
                yield from dfs(node.right)

        return list(dfs(root1)) == list(dfs(root2))

yield를 사용한 신기한 방법이다.
generator을 이렇게 이용할 수 있다는 것을 공부할 수 있었다.

'''