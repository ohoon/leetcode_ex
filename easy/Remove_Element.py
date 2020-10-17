'''
27.
Remove Element
https://leetcode.com/problems/remove-element/
'''

class Solution:
    def removeElement(self, nums: list(int), val: int) -> int:
        length = len(nums)
        cursor = length - 1         # val을 만나면 대체할 숫자의 인덱스
        
        for i in range(length - 1, -1, -1):     # 뒤에서부터 탐색
            if nums[i] == val:
                if i == cursor:         # 찾은 위치가 대체할 필요가 없는 배열 뒷부분일 경우 cursor값만 1 낮추고 다음 탐색으로
                    cursor -= 1
                    continue
                
                nums[i] = nums[cursor]      # cursor에 위치한 숫자로 대체하고 cursor값 1 낮춤
                cursor -= 1
                
        return cursor + 1
        

'''
Runtime: 32 ms, faster than 72.66% of Python3 online submissions for Remove Element.
Memory Usage: 14.1 MB, less than 99.96% of Python3 online submissions for Remove Element.
'''

'''
여담

이젠 이런 유형에 좀 익숙해진듯 금새 풀었다.
계속 노력해서 다양한 알고리즘이 나한테 점점 익숙하게 다가오도록 해야겠다.

'''