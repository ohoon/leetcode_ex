'''
28.
Implement strStr()
https://leetcode.com/problems/implement-strstr/
'''

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        haystack_length = len(haystack)
        needle_length = len(needle)
        
        if needle_length == 0:
            return 0
        
        for i in range(haystack_length - needle_length + 1):
            if haystack[i:i + needle_length] == needle:
                return i
        
        return -1
        

'''
Runtime: 28 ms, faster than 85.17% of Python3 online submissions for Implement strStr().
Memory Usage: 14.2 MB, less than 7.86% of Python3 online submissions for Implement strStr().
'''

'''
여담

python에서 제공하는 find 함수를 쓰면 간단해지겠지만
그런 풀이가 출제자가 원하는 풀이는 아닌듯 싶어 for문으로 풀이했다.
메모리 크기가 크게 나온 건 아마 다른 사람들은 find처럼 라이브러리 함수를 사용해서 그런거 같다.

'''