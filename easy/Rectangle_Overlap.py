'''
836.
Rectangle Overlap
https://leetcode.com/problems/rectangle-overlap/
'''

class Solution:
    def isRectangleOverlap(self, rec1: list(int), rec2: list(int)) -> bool:
        if rec1[0] == rec1[2] or rec1[1] == rec1[3] or rec2[0] == rec2[2] or rec2[1] == rec2[3]:    # 직사각형이 아닌 경우
            return False
        
        if rec1[0] >= rec2[2] or rec1[2] <= rec2[0]:            # x값을 기준으로 겹침 확인
            return False
        
        if rec1[1] >= rec2[3] or rec1[3] <= rec2[1]:            # y값을 기준으로 겹침 확인
            return False
        
        return True

'''
Runtime: 24 ms, faster than 95.60% of Python3 online submissions for Rectangle Overlap.
Memory Usage: 14.2 MB, less than 50.26% of Python3 online submissions for Rectangle Overlap.
'''