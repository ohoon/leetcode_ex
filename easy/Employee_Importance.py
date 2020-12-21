'''
690.
Employee Importance
https://leetcode.com/problems/employee-importance/
'''

class Employee:
    def __init__(self, id: int, importance: int, subordinates: list(int)):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:
    def getImportance(self, employees: list('Employee'), id: int) -> int:
        hash_map = {}
        def calcImportance(id: int) -> int:         # 해시맵에 저장된 데이터를 참조하여 자신의 importance와 부하직원의 importance의 합을 반환하는 재귀 함수
            nonlocal hash_map
            
            return hash_map[id][0] + sum(calcImportance(subId) for subId in hash_map[id][1])
        
        for em in employees:                        # 해시맵에 직원 데이터 저장
            hash_map[em.id] = [em.importance, em.subordinates]
        
        return calcImportance(id)

'''
Runtime: 36 ms, faster than 86.03% of Python3 online submissions for Baseball Game.
Memory Usage: 14.3 MB, less than 86.84% of Python3 online submissions for Baseball Game.
'''