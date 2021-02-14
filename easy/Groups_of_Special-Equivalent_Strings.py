'''
893.
Groups of Special-Equivalent Strings
https://leetcode.com/problems/groups-of-special-equivalent-strings/
'''

class Solution:
    def numSpecialEquivGroups(self, A: list(str)) -> int:
        hash_map = {}
        
        for a in A:
            key = "".join(sorted(a[0::2])+ sorted(a[1::2]))         # 짝수 인덱스의 요소들을 정렬, 홀수 인덱스의 요소들을 정렬하여 key 값으로 설정
            if key in hash_map:                                     # 해당 key값으로 해시 테이블을 구성, swap해서 같은 값이 될 수 있는 것은 같은 key값을 가질 것임
                hash_map[key] += 1
            else:
                hash_map[key] = 1
        
        return len(hash_map)

'''
Runtime: 32 ms, faster than 100.00% of Python3 online submissions for Groups of Special-Equivalent Strings.
Memory Usage: 14.2 MB, less than 99.73% of Python3 online submissions for Groups of Special-Equivalent Strings.
'''