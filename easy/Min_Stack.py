'''
155.
Min Stack
https://leetcode.com/problems/min-stack/
'''

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = float('inf')     # 최솟값 저장
        self.prev = []      # 최솟값 갱신 기록

    def push(self, x: int) -> None:
        if x <= self.min:       # push된 값이 최솟값보다 작으면 최솟값 갱신하고 이전 최솟값은 prev에 저장
            self.prev.append(self.min)
            self.min = x
            
        self.stack.append(x)

    def pop(self) -> None:
        if self.stack[-1] == self.min:      # 최솟값이 pop된 경우, prev에서 그 전의 최솟값을 불러와서 최솟값으로 지정
            self.min = self.prev.pop()
            
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min

'''
Runtime: 56 ms, faster than 87.99% of Python3 online submissions for Min Stack.
Memory Usage: 17.8 MB, less than 90.87% of Python3 online submissions for Min Stack.
'''

'''
여담

이런 문제는 처음 풀어봐서 문제를 이해하는데 시간이 조금 걸렸다.
기존 배열 메소드인 append와 pop를 써도 되는건지 의아했는데, 문제의 목적은 getMin 함수를 내장하고 있는
커스텀 스택 자료구조의 구현이기 때문에 사용해서 풀이했다.

'''