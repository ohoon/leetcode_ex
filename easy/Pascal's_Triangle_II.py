'''
119.
Pascal's Triangle II
https://leetcode.com/problems/pascals-triangle-ii/
'''

class Solution:
    def getRow(self, rowIndex: int) -> list(int):
        row = []
        stack = []
        for i in range(rowIndex + 1):
            row.append(1)
            for j in range(1, i + 1):
                merge = row[j] + row[j-1]       # 다음 행을 위한 덧셈
                if stack and j != 1:            # 스택에 전의 덧셈 결과가 있으면 이전 항에 저장
                    row[j-1] = stack.pop()
                    
                stack.append(merge)             # 덧셈 값을 바로 다음 항을 위해 스택에 보관
        
        return row

'''
Runtime: 28 ms, faster than 79.90% of Python3 online submissions for Pascal's Triangle II.
Memory Usage: 14.1 MB, less than 100.00% of Python3 online submissions for Pascal's Triangle II.
'''

'''
다른 사람의 풀이

class Solution:
    def getRow(self, k: int) -> List[int]:
        l=[1]*(k+1)
        for j in range(1,k+1):
            a=l[0]
            b=l[1]
            for i in range(1,j):
                l[i]=a+b
                a=b
                b=l[i+1]
        return l

Follow up으로 주어진 조건은 O(k)의 space로 문제를 해결하는 것이었음
그래서 k만큼 1씩 append해서 기본 배열을 만들고
1개의 공간은 가지는 스택을 이용해서 더한 결과를 임시로 저장하는 용도로 풀이했다.
하지만 출제자가 원하는 코드는 위의 코드가 더 적합한 것 같다.
append하지 않고 아예 [1, ..., 1]로 배열을 생성하고 포인터로 1~n단계의 덧셈연산을 하는 방법으로 풀이한 것이다.

'''