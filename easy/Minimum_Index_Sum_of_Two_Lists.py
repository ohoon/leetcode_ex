'''
599.
Minimum Index Sum of Two Lists
https://leetcode.com/problems/minimum-index-sum-of-two-lists/
'''

class Solution:
    def findRestaurant(self, list1: list(str), list2: list(str)) -> list(str):
        hash_map = {}               # list1의 데이터가 들어갈 해시맵
        common = []                 # 최소 인덱스 차를 가지는 공통 장소
        least_sum = float('Inf')    # 최소 인덱스 차이 값
        for i, x in enumerate(list1):
            hash_map[x] = i
        
        for i, x in enumerate(list2):
            if x in hash_map:
                index_sum = hash_map[x] + i         # 해당 공통 장소의 인덱스 차이 값
                if index_sum < least_sum:           # 최소값일 경우, 공통 장소 배열과 최소 인덱스 차이 값 갱신
                    least_sum = index_sum
                    common = [x]
                    continue
                
                if index_sum == least_sum:          # 기존 최소값과 같을 경우, 공통 장소 배열에 해당 장소를 추가
                    common.append(x)
                    
        return common

'''
Runtime: 144 ms, faster than 85.87% of Python3 online submissions for Minimum Index Sum of Two Lists.
Memory Usage: 14.8 MB, less than 27.33% of Python3 online submissions for Minimum Index Sum of Two Lists.
'''