'''
1.
Two Sum
https://leetcode.com/problems/two-sum/
'''

class Solution:
    def twoSum(self, nums: list(int), target: int) -> list(int):
        hash_map = {}
        for i in range(len(nums)):
            if (target-nums[i] in hash_map):        # 현재 값에서 target까지 필요한 값(target - nums[i])이 hash에 있는지 확인
                return [hash_map[target-nums[i]], i]
            
            hash_map[nums[i]] = i   # 없으면 현재 nums[i]를 key로, i를 value로 하는 hash에 저장

'''
Runtime: 40 ms, faster than 98.34% of Python3 online submissions for Two Sum.
Memory Usage: 15.2 MB, less than 15.54% of Python3 online submissions for Two Sum.
'''

'''
여담

처음에는 누구나 쉽게 생각하든 단순 brute-force 접근법을 사용했다.
그러다보니 O(N*N)의 시간복잡도가 소모되고, 속도가 많이 느려서 깊은 고민에 빠졌다.
아무리 봐도 brute-force 말곤 방법이 없는데 뭘 놓쳤지 생각을 계속하다가
결국 문제에 있는 hint를 조금씩 봤는데, hash 얘기가 나오는 순간
아...... hash map을 활용하는 숙련도가 아직 많이 부족하다고 느꼈다.
단순히 1~N만큼 해쉬맵에 넣고 다시 1~N부터 탐색하면서 해쉬맵에 있는지 확인하는 것보단
한번 1~N 탐색할 때 그때마다 요소를 해쉬맵에 넣으면서 있는지 확인하면 훨씬 소모 시간이 줄 것이라고 생각하고
구현을 했더니 효율성 98.34퍼가 나왔다 ㅠㅠㅠ solution도 나의 코드와 거의 같다는 점에서 더 기뻤다.
힌트를 보고 hash를 깨달은 건 좀 아쉽지만 그래도 hash라는 힌트 하나로 1-pass 알고리즘을 생각한 건 잘했다고 생각한다.

'''