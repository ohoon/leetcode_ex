'''
697.
Degree of an Array
https://leetcode.com/problems/degree-of-an-array/
'''

class Solution:
    def findShortestSubArray(self, nums: list(int)) -> int:
        hash_map = {}           # {탐색하여 나온 요소: [인덱스들]}
        max_elements = []       # 최대 degree를 가지는 요소
        max_degree = 0          # 최대 degree
        for i in range(len(nums)):
            element = nums[i]
            if element in hash_map:
                hash_map[element].append(i)
                degree = len(hash_map[element])
                if degree > max_degree:             # 기존의 최대 degree보다 높아졌다면 max_elements를 버리고 새로 구성
                    max_elements = [element]
                    max_degree = degree
                elif degree == max_degree:          # 기존의 최대 degree와 같다면 max_elements에 해당 요소 추가
                    max_elements.append(element)
                    
                continue
            
            hash_map[nums[i]] = [i]
        
        if not max_elements:                        # 모든 요소가 한 번씩만 나온 경우
            return 1
        
        return min(hash_map[elem][-1] - hash_map[elem][0] + 1 for elem in max_elements)     # max_elements 요소들 중 첫 요소와 마지막 요소의 차이, 즉 폭이 가장 작은 값을 반환

'''
Runtime: 220 ms, faster than 83.79% of Python3 online submissions for Degree of an Array.
Memory Usage: 16.8 MB, less than 5.07% of Python3 online submissions for Degree of an Array.
'''

'''
다른 풀이

class Solution(object):
    def findShortestSubArray(self, nums):
        left, right, count = {}, {}, {}
        for i, x in enumerate(nums):
            if x not in left: left[x] = i
            right[x] = i
            count[x] = count.get(x, 0) + 1

        ans = len(nums)
        degree = max(count.values())
        for x in count:
            if count[x] == degree:
                ans = min(ans, right[x] - left[x] + 1)

        return ans

내 풀이의 경우는 최대 degree와 그 값을 가지는 값을 저장하며 one-pass로 탐색하는 방법이고
이 풀이는 해시맵을 3개 사용해서 if x not in으로 가장 처음으로 만난 값만 저장하여 left를, 만나는 값마다 계속 덮어씌우는 성질을 이용하여 right를 구현하였다.
count는 최대 degree를 구하기 위해서 빈도수를 저장해놓은 해시맵이다. 최대 degree를 구할 때 max함수를 사용하고, 그 값을 이용해 left, right 해시맵을 한번 더 탐색해야하므로
시간적으로는 내 풀이가 더 좋다고 생각된다. 하지만 다른 사람이 보고 이해하기 쉬운 풀이는 이 풀이가 더 적합하다고 생각한다.

'''