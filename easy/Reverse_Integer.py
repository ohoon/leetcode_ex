'''
2.
Reverse Integer
https://leetcode.com/problems/reverse-integer/
'''

class Solution:
    def reverse(self, x: int) -> int:
        # x = 양수
        if (x > 0):
            answer = int(str(x)[::-1])      # x를 reverse해서 answer에 저장
            return answer if answer < 2**31 else 0      # overflow가 아니면 answer 반환

        # x = 0
        elif (x == 0):
            return 0

        # x = 음수
        answer = -int(str(x)[1:][::-1])         # 부호를 제외하고 reverse해서 음수형태로 answer에 저장
        return answer if answer >= -2**31 else 0        # overflow가 아니면 answer 반환

'''
Runtime: 24 ms, faster than 96.73% of Python3 online submissions for Reverse Integer.
Memory Usage: 14.2 MB, less than 99.98% of Python3 online submissions for Reverse Integer.
'''

'''
여담

그냥 단순하게 문자열로 변환해서 뒤집는 방법을 사용했는데, 출제자가 원하는 답이 아닌거 같아서 솔루션을 봤더니
10씩 나머지를 구하고 나눗셈을 해서 rev에 더해가는 방법이다. 더해가면서 이 답의 다음 단계가 overflow의 조짐이 있는지 확인하는 것으로
overflow를 예방하는 거였는데 직접 구현해보니 python3에서는 나머지 연산이 다른 언어 환경이랑 달라서 구현하기가 힘들었다.
어떻게 조건을 달아서 완성을 해봤는데 별로 내 코드랑 속도가 크게 다르지 않는거 같다.

'''