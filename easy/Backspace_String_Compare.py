'''
844.
Backspace String Compare
https://leetcode.com/problems/backspace-string-compare/
'''

class Solution:
    def backspaceCompare(self, S: str, T: str) -> bool:
        S, T = list(S), list(T)
        skip = 0
        
        while S or T:
            s = ''
            skip = 0
            while S:                # 각 문자열의 오른쪽부터 문자를 하나씩 뽑아서 비교, #이 나오면 나온 개수만큼 pop을 재반복하여 스킵
                elem = S.pop()
                if elem == '#':
                    skip += 1
                    continue
                
                if skip > 0:
                    skip -= 1
                    continue
                
                s = elem
                break
            
            t = ''
            skip = 0
            while T:
                elem = T.pop()
                if elem == '#':
                    skip += 1
                    continue
                
                if skip > 0:
                    skip -= 1
                    continue
                
                t = elem
                break
            
            if s != t:
                return False
            
        return True

'''
Runtime: 28 ms, faster than 85.41% of Python3 online submissions for Backspace String Compare.
Memory Usage: 14.4 MB, less than 22.78% of Python3 online submissions for Backspace String Compare.
'''

'''
다른 사람의 풀이

class Solution(object):
    def backspaceCompare(self, S, T):
        def F(S):
            skip = 0
            for x in reversed(S):
                if x == '#':
                    skip += 1
                elif skip:
                    skip -= 1
                else:
                    yield x

        return all(x == y for x, y in itertools.izip_longest(F(S), F(T)))

내 풀이에서는 while이 중첩되고 코드가 복잡해지면서 비교적 이해하기 힘들었는데
위의 풀이는 generator과 izip_longest라는 itertools의 함수를 이용해서 간단하게 풀이했다.
제네레이터의 yield를 이렇게 활용할 수 있구나 생각이 들었다.
고급 함수들을 이용한 풀이의 중요성을 새삼 다시 느꼈다.

'''