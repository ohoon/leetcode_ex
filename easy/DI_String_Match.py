'''
942.
DI String Match
https://leetcode.com/problems/di-string-match/
'''

class Solution:
    def diStringMatch(self, S: str) -> list(int):
        maxNum, minNum = 0, 0
        answer = [0]
        for s in S:
            if s == 'I':            # I일 경우 maxNum을 1 증가시키고 배열에 추가
                maxNum += 1
                answer.append(maxNum)
            elif s == 'D':          # D일 경우 minNum을 1 감소시키고 배열에 추가
                minNum -= 1
                answer.append(minNum)
        
        return [x - minNum for x in answer]     # 구한 배열을 minNum의 절댓값만큼 더해줘 최소값이 0이 되도록 만듦

'''
Runtime: 56 ms, faster than 96.48% of Python3 online submissions for DI String Match.
Memory Usage: 15.5 MB, less than 9.45% of Python3 online submissions for DI String Match.
'''

'''
다른 풀이

class Solution(object):
    def diStringMatch(self, S):
        lo, hi = 0, len(S)
        ans = []
        for x in S:
            if x == 'I':
                ans.append(lo)
                lo += 1
            else:
                ans.append(hi)
                hi -= 1

        return ans + [lo]

내 코드의 경우에는 처음에 0으로 시작해서 ID 패턴에 맞게 배열을 만들고 최소값만큼 모든 값을 올려주는 방식으로 풀이했는데,
이 방법처럼 애초에 I일 때는 낮은 값부터 차곡차곡 쌓고 D일 때는 높은 값부터 쌓으면서 하는 방법이 깔끔하고 좋은 것 같다.
풀이하는 방식의 큰 줄기는 같지만 좀 더 깔끔하게 코딩하지 못한게 아쉽다.

'''