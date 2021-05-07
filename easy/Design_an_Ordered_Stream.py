'''
1656.
Design an Ordered Stream
https://leetcode.com/problems/design-an-ordered-stream/
'''

class OrderedStream:

    def __init__(self, n: int):
        self.list = [None] * n      # n 사이즈로 초기화
        self.ptr = 0                # 포인터

    def insert(self, idKey: int, value: str) -> list(str):
        self.list[idKey - 1] = value        # key 위치에 value 삽입

        returnValue = []            # 반환한 값을 지닌 리스트
        while self.ptr < len(self.list) and self.list[self.ptr]:    # 포인터가 가리킨 곳에 데이터가 있으면 반환 리스트에 추가
            returnValue.append(self.list[self.ptr])
            self.ptr += 1       # 포인터를 증가시키고 반복

        return returnValue


# Your OrderedStream object will be instantiated and called as such:
# obj = OrderedStream(n)
# param_1 = obj.insert(idKey,value)

'''
Runtime: 220 ms, faster than 54.25% of Python3 online submissions for Design an Ordered Stream.
Memory Usage: 15.2 MB, less than 28.05% of Python3 online submissions for Design an Ordered Stream.
'''