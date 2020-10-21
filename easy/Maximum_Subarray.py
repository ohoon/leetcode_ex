'''
53.
Maximum Subarray
https://leetcode.com/problems/maximum-subarray/
'''

class Solution:
    def maxSubArray(self, nums: list(int)) -> int:
        newNum = maxTotal = nums[0]        

        for i in range(1, len(nums)):
            newNum = max(nums[i], nums[i] + newNum)     # 앞에서부터 누적되는 것과 현재 위치에서 새로 시작하는 것, 둘 중에 뭐가 가치가 높은지 검사
            maxTotal = max(newNum, maxTotal)        # newNum의 최댓값을 maxTotal에서 관리

        return maxTotal
        

'''
Runtime: 60 ms, faster than 92.38% of Python3 online submissions for Maximum Subarray.
Memory Usage: 14.9 MB, less than 84.56% of Python3 online submissions for Maximum Subarray.
'''

'''
여담

결론부터 말하면 못풀었다.
문제에서 O(N)으로 풀었다면 Divide and Conquer 전략으로 풀어봐라. 라고 돼있어서
그냥 시작부터 DC 전략으로 생각을 했다. 근데 너무..... 어려웠다.
1시간동안 머리 꽁꽁 싸매다가 아예 감이 안잡혀서 O(N) 방법으로 순회했는데
그마저도 쉽지 않았다. 2시간쯤 지나니까 이정도면 못푸는게 맞다고 인정하고 답을 확인해서 로직을 머리에 익히는게 낫다고 판단했다.
위의 코드는 다른 사람이 풀이한 코드로써 kadane algorithm라고 유명한 알고리즘이라고 한다.
이 알고리즘은 O(N)의 시간복잡도와 O(1)의 메모리공간을 차지한다.
그래도 kadane algorithm에 대해 알게되는 뜻깊은 시간이었다. 아 그리고 DC 전략으로 풀이한 코드도 분석해서 이해할 수 있도록 해야겠다.

'''