'''
100.
Same Tree
https://leetcode.com/problems/same-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        
        left = [root.left]
        right = [root.right]
        
        # root를 기준으로 좌/우측으로 노드를 탐색하며 비교 시작
        while left and right:
            temp = [[], []]     # temp[0]: 좌측 노드 값들, temp[1]: 우측 노드 값들
            
            for x, y in zip(left, right):
                if not (x or y):        # 둘 다 빈 노드라면 다음 노드로
                    continue
                    
                if not (x and y) or x.val != y.val:     # 노드가 짝이 안맞으면 False 반환
                    return False
                
                temp[0].append(x.left)
                temp[0].append(x.right)
                temp[1].append(y.right)     # 우측 노드는 right 노드부터 추가
                temp[1].append(y.left)
            
            left = temp[0]
            right = temp[1]
        
        return True

'''
Runtime: 28 ms, faster than 93.61% of Python3 online submissions for Symmetric Tree.
Memory Usage: 14.3 MB, less than 100.00% of Python3 online submissions for Symmetric Tree.
'''

'''
재귀법 풀이

class Solution:
    def treeToList(self, node: TreeNode, direction):
        if not node:
            return [None]
        
        if direction > 0:
            return [node.val] + [self.treeToList(node.left, direction)] + [self.treeToList(node.right, direction)]
        
        return [node.val] + [self.treeToList(node.right, direction)] + [self.treeToList(node.left, direction)]
    
    def isSymmetric(self, root: TreeNode) -> bool:
        return not root or self.treeToList(root.left, 1) == self.treeToList(root.right, -1)

반복법의 경우는 BFS, 재귀법의 경우는 DFS 형식으로 풀이했음
BFS는 탐색하면서 맞는지 비교가 가능하기 때문에 중간에 False를 반환할 수 있는 반면에,
DFS는 완전탐색이 불가피하기 때문에 배열에다가 탐색한 경로를 누적시켜 root의 좌/우 탐색경로를 비교하여 풀이하는 방식을 택했다.
'''