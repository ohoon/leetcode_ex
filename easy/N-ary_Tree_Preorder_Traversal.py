'''
589.
N-ary Tree Preorder Traversal
https://leetcode.com/problems/n-ary-tree-preorder-traversal/
'''

class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children

class Solution:
    def preorder(self, root: 'Node') -> list(int):
        if not root:
            return []
        
        traversal = [root.val]
        if not root.children:
            return traversal
        
        for child in root.children:
            traversal += self.preorder(child)
        
        return traversal                        # traversal = [부모노드, 자식노드1, 자식노드2, ...]

'''
Runtime: 48 ms, faster than 80.39% of Python3 online submissions for N-ary Tree Preorder Traversal.
Memory Usage: 16 MB, less than 31.87% of Python3 online submissions for N-ary Tree Preorder Traversal.
'''

'''
반복법 풀이

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        traversal = []
        stack = [root]
        while stack:
            node = stack.pop()
            if node:
                traversal.append(node.val)              # 탐색한 노드 기록
                stack += node.children[::-1]            # 자식 노드 역순으로 스택에 추가
        
        return traversal

iterative하게 풀기 위해서 스택을 이용하였음
append와 pop으로 자식노드를 탐색하기 때문에 append할 때 자식 노드를 역방향으로 삽입해야 pop할 때 정방향으로 탐색할 수 있음

'''