'''
111.
Minimum Depth of Binary Tree
https://leetcode.com/problems/minimum-depth-of-binary-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
            
        node = [root]
        depth = 1
        
        while True:
            sub_node = []           # 다음 depth의 노드들
            
            for n in node:
                if not(n.left or n.right):      # 단말 노드라면 depth를 반환하고 종료
                    return depth

                if n.left:
                    sub_node.append(n.left)
                    
                if n.right:
                    sub_node.append(n.right)
            
            node = sub_node
            depth += 1

'''
Runtime: 480 ms, faster than 52.74% of Python3 online submissions for Minimum Depth of Binary Tree.
Memory Usage: 49.4 MB, less than 11.67% of Python3 online submissions for Minimum Depth of Binary Tree.
'''

'''
여담

BFS와 DFS중에서 이 문제를 빠르게 풀기 위해서는 BFS 접근방식이 효율적이라고 생각했음
DFS의 경우는 left 노드들이 max_depth정도로 깊고 right 노드가 짧을경우 불필요하게 max_depth까지 탐색해야함
BFS의 경우는 가로로 탐색하면서 단말 노드를 찾으면 return하는 것으로 프로그램이 끝나기 때문에 효율적이다.

'''