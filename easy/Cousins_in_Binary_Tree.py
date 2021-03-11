'''
993.
Cousins in Binary Tree
https://leetcode.com/problems/cousins-in-binary-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        travel = [root]
        while travel:                   # BFS
            nxt = []
            count = 0                   # 이번 depth에서 찾은 총 x y 갯수
            while travel:
                node = travel.pop()
                _count = 0              # 이번 parent node에서 찾은 x y 갯수
                if node.left:
                    nxt.append(node.left)
                    if node.left.val in (x, y):
                        _count += 1
                
                if node.right:
                    nxt.append(node.right)
                    if node.right.val in (x, y):
                        _count += 1
                
                if _count == 2:         # 같은 parent에서 x y가 나오면 False
                    return False
                
                count += _count
            
            if count == 2:              # 같은 depth에서 다른 parent로부터 x y를 모두 찾으면 True
                return True
            
            travel = nxt

'''
Runtime: 32 ms, faster than 70.81% of Python3 online submissions for Cousins in Binary Tree.
Memory Usage: 14.3 MB, less than 71.00% of Python3 online submissions for Cousins in Binary Tree.
'''

'''
여담

같은 depth에 있는 노드끼리 비교하는 것이 중요하기 때문에 bfs로 풀이했다.
동작한 결과는 나쁘지않게 나왔지만 생각보다 코드가 지저분해져서 마음에 안듦

'''