'''
985.
Sum of Even Numbers After Queries
https://leetcode.com/problems/sum-of-even-numbers-after-queries/
'''

class Solution:
    def sumEvenAfterQueries(self, A: list(int), queries: list(list(int))) -> list(int):
        answer = []
        sumOfEven = sum(a for a in A if a % 2 == 0)         # 짝수 인덱스의 요소들의 합
        for val, index in queries:
            prev = A[index]                                 # val만큼 더하기 전의 요소 값을 저장
            A[index] += val
            if A[index] % 2 == 0:							# 더한 결과 값이 짝수면
                if prev % 2 == 0:							# 이전 값 또한 짝수였다면 증가한 val 값만큼만 sumOfEven에 더해서 answer에 append
                    sumOfEven += val
                    answer.append(sumOfEven)
                else:										# 이전 값은 홀수였다면 더한 결과 값을 sumOfEven에 더해서 answer에 append
                    sumOfEven += A[index]
                    answer.append(sumOfEven)
            else:											# 더한 결과 값이 홀수면
                if prev % 2 == 0:							# 이전 값은 짝수였다면 이전 값만큼 sumOfEven에 빼고 answer에 append
                    sumOfEven -= prev
                    answer.append(sumOfEven)
                else:										# 이전 값 또한 홀수였다면 변동없이 그대로 answer에 append
                    answer.append(sumOfEven)
        
        return answer

'''
Runtime: 492 ms, faster than 96.44% of Python3 online submissions for Sum of Even Numbers After Queries.
Memory Usage: 20.5 MB, less than 24.37% of Python3 online submissions for Sum of Even Numbers After Queries.
'''