'''
637.
Average of Levels in Binary Tree
https://leetcode.com/problems/average-of-levels-in-binary-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def averageOfLevels(self, root: TreeNode) -> list(float):
        if not root:
            return []
        
        avgs = []
        current = [root]
        while current:
            nextNode = []
            avg = sum(n.val for n in current) / len(current)        # 현재 깊이 노드 값들의 합 / 노드 개수
            avgs.append(avg)
            while current:                                          # 다음 깊이 노드들을 찾아서 nextNode 배열에 저장
                node = current.pop()
                if node.left:
                    nextNode.append(node.left)

                if node.right:
                    nextNode.append(node.right)
            
            current = nextNode                                      # 다음 깊이로 이동
        
        return avgs

'''
Runtime: 36 ms, faster than 99.85% of Python3 online submissions for Average of Levels in Binary Tree.
Memory Usage: 16.7 MB, less than 29.79% of Python3 online submissions for Average of Levels in Binary Tree.
'''