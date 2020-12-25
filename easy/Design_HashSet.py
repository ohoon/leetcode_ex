'''
705.
Design HashSet
https://leetcode.com/problems/design-hashset/
'''

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.MAX_SIZE = 1000
        self.storage = [None] * self.MAX_SIZE

    def add(self, key: int) -> None:                # key값을 MAX_SIZE에 나눈 나머지를 인덱스로 하여 storage 배열 안에 저장함
        idx = key % self.MAX_SIZE
        if self.storage[idx]:
            if key not in self.storage[idx]:        # 이미 key값이 저장되어있으면 패스
                self.storage[idx].append(key)
        else:                                       # 인덱스에 처음으로 접근하였을 때는 key값이 들어갈 배열 생성
            self.storage[idx] = [key]

    def remove(self, key: int) -> None:                     # 해싱 인덱스에 접근하여 key값이 있으면 제거
        idx = key % self.MAX_SIZE
        if self.storage[idx] and key in self.storage[idx]:
            self.storage[idx].remove(key)

    def contains(self, key: int) -> bool:                   # 해싱 인덱스에 접근하여 key값이 있는지 탐색
        """
        Returns true if this set contains the specified element
        """
        idx = key % self.MAX_SIZE
        return key in self.storage[idx] if self.storage[idx] else False

'''
Runtime: 148 ms, faster than 87.22% of Python3 online submissions for Design HashSet.
Memory Usage: 18.7 MB, less than 68.53% of Python3 online submissions for Design HashSet.
'''