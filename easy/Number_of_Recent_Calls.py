'''
933.
Number of Recent Calls
https://leetcode.com/problems/number-of-recent-calls/
'''

class RecentCounter:

    def __init__(self):
        self.request = []
        self.minIndex = -1          # ping 범위에 속하는 최솟값 인덱스

    def ping(self, t: int) -> int:
        self.request.append(t)
        
        _range = [-3000 + t, t]
        length = len(self.request)
        
        if self.minIndex > -1:                      # 최솟값 인덱스가 존재하면
            for i in range(self.minIndex, length):  # 최솟값 인덱스부터 탐색하여 핑 범위에 속하는 인덱스 저장
                if self.request[i] >= _range[0]:
                    self.minIndex = i
                    break
        else:
            self.minIndex = 0
        
        return length - self.minIndex               # 최솟값 이상 핑들의 개수 반환

'''
Runtime: 312 ms, faster than 41.88% of Python3 online submissions for Number of Recent Calls.
Memory Usage: 19.4 MB, less than 11.62% of Python3 online submissions for Number of Recent Calls.
'''

'''
다른 풀이

class RecentCounter:

    def __init__(self):
        self.slide_window = deque()

    def ping(self, t: int) -> int:
        # step 1). append the current call
        self.slide_window.append(t)

        # step 2). invalidate the outdated pings
        while self.slide_window[0] < t - 3000:
            self.slide_window.popleft()

        return len(self.slide_window)

최솟값 위치를 가리키는 인덱스를 사용할 필요 없이 deque를 이용하면 간단하게 풀이할 수 있는 문제였다.
슬라이딩 윈도우하면 deque인데 생각해내지 못한게 아쉬움

'''