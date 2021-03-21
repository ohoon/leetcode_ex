'''
1103.
Distribute Candies to People
https://leetcode.com/problems/distribute-candies-to-people/
'''

class Solution:
    def distributeCandies(self, candies: int, num_people: int) -> list(int):
        people = [0] * num_people           # 초기화
        candy = 1
        while True:
            for i in range(num_people):
                if candies > candy:         # 보유한 candies 수가 넉넉하면 candy만큼만 배급
                    people[i] += candy
                    candies -= candy
                    candy += 1
                else:                       # candies가 candy 이하면 candies만큼만 배급하고 return
                    people[i] += candies
                    return people

'''
Runtime: 40 ms, faster than 67.33% of Python3 online submissions for Distribute Candies to People.
Memory Usage: 14.3 MB, less than 85.65% of Python3 online submissions for Distribute Candies to People.
'''
