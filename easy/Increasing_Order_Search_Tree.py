'''
897.
Increasing Order Search Tree
https://leetcode.com/problems/increasing-order-search-tree/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:
        def inorder(node):                          # inorder 방식으로 탐색하면서 cur이라는 Tree를 새로 작성
            if node:
                inorder(node.left)
                self.cur.right = TreeNode(node.val)
                self.cur = self.cur.right
                inorder(node.right)
            
        answer = self.cur = TreeNode()              # cur의 시작지점을 answer로 저장
        inorder(root)
        
        return answer.right                         # answer의 right부터 탐색이 기록되기 때문

'''
Runtime: 16 ms, faster than 99.96% of Python3 online submissions for Increasing Order Search Tree.
Memory Usage: 14.4 MB, less than 47.12% of Python3 online submissions for Increasing Order Search Tree.
'''

'''
여담

오랜만에 트리 문제를 풀어서 그런지 문제 풀이법을 생각하는데 어려움이 많이 있었다.
코드만 장황해지고 결론이 안나서 결국 솔루션을 보고 이해하기로 했다.
기록해놓고 다음에 다시 풀어봐야겠음

'''