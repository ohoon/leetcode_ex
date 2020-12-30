'''
744.
Find Smallest Letter Greater Than Target
https://leetcode.com/problems/find-smallest-letter-greater-than-target/
'''

class Solution:
    def nextGreatestLetter(self, letters: list(str), target: str) -> str:
        left, right = 0, len(letters)
        while left < right:
            mid = (left + right) // 2
            if letters[mid] > target:
                right = mid
                continue
            
            left = mid + 1
        
        return letters[left % len(letters)]


'''
Runtime: 104 ms, faster than 83.96% of Python3 online submissions for Find Smallest Letter Greater Than Target.
Memory Usage: 14.6 MB, less than 25.31% of Python3 online submissions for Find Smallest Letter Greater Than Target.
'''

'''
다른 풀이

class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        for x in letters:
            if x > target:
                return x
        
        return letters[0]

one-pass로 for문 탐색하면서 target보다 큰 알파벳이 나오면 반환하는 풀이다.
시간복잡도는 O(N)으로, 이진탐색보다는 오래 걸리는 편이다.
하지만 쉽게 코드를 이해할 수 있다는 장점이 있음

'''