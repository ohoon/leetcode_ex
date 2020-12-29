'''
733.
Flood Fill
https://leetcode.com/problems/flood-fill/
'''

class Solution:
    def floodFill(self, image: list(list(int)), sr: int, sc: int, newColor: int) -> list(list(int)):
        rows, cols = len(image), len(image[0])
        color = image[sr][sc]
        if color == newColor:
            return image
        
        def paint(r: int, c: int):
            if image[r][c] == color:
                image[r][c] = newColor
                if r > 0:
                    paint(r - 1, c)
                    
                if r < rows - 1:
                    paint(r + 1, c)
                    
                if c > 0:
                    paint(r, c - 1)
                    
                if c < cols - 1:
                    paint(r, c + 1)
                
        paint(sr, sc)
        
        return image

'''
Runtime: 80 ms, faster than 23.40% of Python3 online submissions for Flood Fill.
Memory Usage: 14.5 MB, less than 37.36% of Python3 online submissions for Flood Fill.
'''