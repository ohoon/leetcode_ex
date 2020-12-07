'''
530.
Minimum Absolute Difference in BST
https://leetcode.com/problems/minimum-absolute-difference-in-bst/
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def getMinimumDifference(self, root: TreeNode) -> int:
        if not root or (not root.left and not root.right):
            return float('inf')
        
        left_side, right_side = float('inf'), float('inf')
        if root.left:
            node = root.left
            while node.right:               # root보다 작은 수 중에 가장 가까운 수를 찾기
                node = node.right
            
            left_side = abs(root.val - node.val)    # 두 수의 차이를 left_side에 저장
        
        if root.right:
            node = root.right
            while node.left:                # root보다 큰 수 중에 가장 가까운 수를 찾기
                node = node.left
                
            right_side = abs(root.val - node.val)   # 두 수의 차이를 right_side에 저장
            
        return min(left_side, right_side, self.getMinimumDifference(root.left), self.getMinimumDifference(root.right))      # 자신과 가장 가까운 차이와 서브트리 반환값 중 최소값 반환

'''
Runtime: 60 ms, faster than 30.71% of Python3 online submissions for Minimum Absolute Difference in BST.
Memory Usage: 16.2 MB, less than 8.44% of Python3 online submissions for Minimum Absolute Difference in BST.
'''

'''
다른 사람의 풀이

class Solution:
    def getMinimumDifference(self, root: TreeNode) -> int:
        output = []
        self.inorder(root,output)
        mini_diff = float('inf')
        for i in range(1,len(output)):
            mini_diff = min(mini_diff,output[i]-output[i-1])
        return mini_diff
        
    def inorder(self,root,output):
        if root == None:
            return 
        else:
            self.inorder(root.left, output)
            output.append(root.val)
            self.inorder(root.right, output)

사실 해당 풀이처럼 트리 구조를 오름차순 정렬 배열로 바꿔서 배열 요소들 간의 차이를 계산하는게 가장 이해하기도 쉽고 빠르다는 걸 알고 있었지만
왠지 내가 풀이한 코드처럼 하는 것이 트리 구조를 머리 속에서 생각하며 계산하는 연습이 되어 좋았다.

'''