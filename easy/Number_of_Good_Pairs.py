'''
1512.
Number of Good Pairs
https://leetcode.com/problems/number-of-good-pairs/
'''

class Solution:
    def numIdenticalPairs(self, nums: list[int]) -> int:
        hash_map = {}
        answer = 0
        for n in nums:
            if n in hash_map:
                answer += hash_map[n]       # 현재까지 중복된 수 만큼 answer에 더함
                hash_map[n] += 1            # 중복 수 + 1
            else:
                hash_map[n] = 1             # 해시맵에 등록

        return answer

'''
Runtime: 20 ms, faster than 99.76% of Python3 online submissions for Number of Good Pairs.
Memory Usage: 14.2 MB, less than 71.82% of Python3 online submissions for Number of Good Pairs.
'''