'''
925.
Long Pressed Name
https://leetcode.com/problems/long-pressed-name/
'''

class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        curN, lenN = 0, len(name)           # name을 탐색하는 포인터
        curT, lenT = 0, len(typed)          # typed를 탐색하는 포인터
        
        while curN < lenN and curT < lenT:
            if name[curN:curN+2] == typed[curT:curT+2]:     # 2개의 글자를 묶음으로 비교해서 같으면 다음 인덱스로
                curN, curT = curN + 1, curT + 1
                continue
            
            if name[curN] == typed[curT]:                   # 다르면 첫 글자만 비교해서 같으면 typed만 다음 인덱스로
                curT = curT + 1
                continue
            
            return False                                    # 아예 다르면 False 반환
        
        return curN == lenN and curT == lenT                # name과 typed 모두 정상적으로 탐색이 완료된 경우에만 True 반환

'''
Runtime: 28 ms, faster than 88.70% of Python3 online submissions for Long Pressed Name.
Memory Usage: 14.2 MB, less than 66.28% of Python3 online submissions for Long Pressed Name.
'''

'''
다른 풀이

class Solution(object):
    def isLongPressedName(self, name, typed):
        g1 = [(k, len(list(grp))) for k, grp in itertools.groupby(name)]
        g2 = [(k, len(list(grp))) for k, grp in itertools.groupby(typed)]
        if len(g1) != len(g2):
            return False

        return all(k1 == k2 and v1 <= v2
                   for (k1,v1), (k2,v2) in zip(g1, g2))

itertools의 groupby 함수를 이용해서 연속되어 나타난 문자들의 개수를 찾아서 name과 typed의 문자 개수를 이용해서 풀어나가는 코드이다.
나도 처음엔 이 방법을 생각해서 Counter을 이용할까 했는데 two pointer 방법이 시간적으로는 더 좋을 것 같아서 이 방법은 쓰지 않았다.
groupby 함수도 유용한 함수인 것 같으니 기억해놨다가 다음에 써먹어야겠다.

'''