'''
167.
Two Sum II - Input array is sorted
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
'''

class Solution:
    def twoSum(self, numbers: list(int), target: int) -> list(int):
        hash_map = {}
        length = len(numbers)
        for i in range(length):         # 해시맵 생성
            if numbers[i] in hash_map:      # 같은 값이 이미 있으면 인덱스만 새로 추가
                hash_map[numbers[i]].append(i)
                continue
                
            hash_map[numbers[i]] = [i]
        
        for num in numbers:
            remain = target - num
            if remain in hash_map:      # 필요값이 해시맵에 있는지 확인
                if num == remain and len(hash_map[num]) == 2:       # target = num*2인 경우
                    return [hash_map[num][0] + 1, hash_map[num][1] + 1]
                
                return [hash_map[num][0] + 1, hash_map[remain][0] + 1]

'''
Runtime: 56 ms, faster than 92.72% of Python3 online submissions for Two Sum II - Input array is sorted.
Memory Usage: 15.2 MB, less than 12.20% of Python3 online submissions for Two Sum II - Input array is sorted.
'''

'''
다른 사람의 풀이

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        ## RC ##
        ## APPRAOCH : 2 POINTER ##
        
		## TIME COMPLEXITY : O(N) ##
		## SPACE COMPLEXITY : O(1) ##

        left = 0
        right = len(nums) - 1
        
        while(left < right):
            if(nums[left] + nums[right] < target):
                left += 1
            if(nums[left] + nums[right] > target):
                right -= 1
            if((nums[left] + nums[right]) == target):
                return [left+1,right+1]

해시맵을 이용해서 O(N)의 시간복잡도와 O(N)의 공간복잡도를 가진 풀이를 했다.
하지만 위의 풀이와 같이 2개의 포인터를 가지고 탐색하는 방법을 쓰면 공간 복잡도를 O(1)까지 줄일 수 있다.
인덱스 0과 n-1를 가리키는 2개의 포인터를 가지고 시작하여 두 포인터 값의 합이 target보다 큰지, 작은지에 따라 포인터를 이동시키는 방법이다.

'''