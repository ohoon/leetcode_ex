'''
590.
N-ary Tree Postorder Traversal
https://leetcode.com/problems/n-ary-tree-postorder-traversal/
'''

class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children

class Solution:
    def postorder(self, root: 'Node') -> list(int):
        if not root:
            return []
        
        traversal = []
        if not root.children:
            return [root.val]
        
        for child in root.children:
            traversal += self.postorder(child)
        
        traversal += [root.val]
        
        return traversal                        # traversal = [자식노드1, 자식노드2, ..., 부모노드]

'''
Runtime: 44 ms, faster than 93.06% of Python3 online submissions for N-ary Tree Postorder Traversal.
Memory Usage: 16.1 MB, less than 22.75% of Python3 online submissions for N-ary Tree Postorder Traversal.
'''

'''
반복법 풀이

class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        traversal = []
        stack = [root]
        while stack:
            node = stack.pop()
            if node:
                traversal.append(node.val)              # 탐색한 노드를 기록
                stack += node.children                  # 자식 노드 순으로 스택에 삽입
        
        return traversal[::-1]                          # 탐색한 노드를 뒤집어서 반환

iterative하게 풀기 위해서 스택을 이용하였음
자식 노드를 만나는 대로 traversal에 append하고 pop하면서 탐색하기 때문에 이를 역으로 뒤집으면 postorder가 된다.

'''