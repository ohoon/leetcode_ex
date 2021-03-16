'''
1025.
Divisor Game
https://leetcode.com/problems/divisor-game/
'''

class Solution:
    def divisorGame(self, N: int) -> bool:
        return N % 2 == 0

'''
Runtime: 28 ms, faster than 85.49% of Python3 online submissions for Divisor Game.
Memory Usage: 14.1 MB, less than 72.25% of Python3 online submissions for Divisor Game.
'''

'''
여담

DP로 풀어야한다는 느낌이 들었지만 어떻게 optimal하게 전개해나갈지 감이 안잡혔다.
결국 다른 사람 풀이를 참고하여 풀이 방식을 공부하기로 다짐했다.
최적 풀이는 DP도 아닌 간단한 방법이었다.
Alice에게 주어진 N이 짝수라면 1은 무조건 약수이므로 1을 뺀 N-1을 Bob에게 준다.
Bob에게 주어진 N은 홀수가 되므로 홀수의 약수는 홀수, Alice에게 넘길 N은 홀수 - 홀수 = 짝수가 된다.
이렇게 Alice는 짝수만 받고 Bob은 홀수만 받으므로 게임을 진행하면 결국 Bob이 1을 가지게되므로 Alice가 절대적으로 승리한다.
만약 처음에 Alice에게 주어진 N이 홀수라면 반대로 Bob이 무조건 짝수를 갖게 되므로 Alice가 절대적으로 패배한다.
이런 패턴을 찾아냈다는 것이 놀랍고 더 공부해야겠다.. 

'''