'''
496.
Next Greater Element I
https://leetcode.com/problems/next-greater-element-i/
'''

class Solution:
    def nextGreaterElement(self, nums1: list(int), nums2: list(int)) -> list(int):
        hash_map = {}
        stack = []
        for n in nums2:
            while stack and n > stack[-1]:      # n이 stack에 있는 각 값의 nextGreaterElement라면 해시맵에 등록
                pop = stack.pop()
                hash_map[pop] = n
            
            stack.append(n)
        
        return [hash_map[n] if n in hash_map else -1 for n in nums1]        # nums1의 각 값이 해시맵에 있으면 해당 값을, 없으면 -1을

'''
Runtime: 48 ms, faster than 62.47% of Python3 online submissions for Next Greater Element I.
Memory Usage: 14.4 MB, less than 36.42% of Python3 online submissions for Next Greater Element I.
'''