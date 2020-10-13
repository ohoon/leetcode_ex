'''
14.
Longest Common Prefix
https://leetcode.com/problems/longest-common-prefix/
'''

class Solution:
    def longestCommonPrefix(self, strs: list(str)) -> str:
        answer = ''
        strs.sort()     # 오름차순 정렬하여 prefix대로 나열되어있음
        
        if (strs and strs[0]):  # strs 자체가 비었거나 strs의 원소 중 공백이 있을 경우 '' 반환
            for i in range( min(len(strs[0]), len(strs[-1])) ):     # 글자 수가 작은 것 기준으로 문자열 앞에서부터 탐색
                if (strs[0][i] != strs[-1][i]):     # prefix대로 나열되어있기 때문에 처음 원소와 끝 원소만 비교, 같지 않으면 종료
                    break

                answer += strs[0][i]
        
        return answer

'''
Runtime: 24 ms, faster than 98.28% of Python3 online submissions for Longest Common Prefix.
Memory Usage: 14.2 MB, less than 100.00% of Python3 online submissions for Longest Common Prefix.
'''

'''
여담

공식 솔루션에는 binary search나 divide and conquer 처럼 반으로 나눠서 탐색하는 방법을 소개하고 있는데,
뭔가 내 코드는 정렬 함수의 원리를 이용한 꼼수를 써서 푼 것같아 마음에 걸린다.
이진 탐색과 분할 정복은 알고리즘하면 주로 쓰이는 기법인데
좀 더 숙지하고 사용할 수 있도록 노력해야겠다.

'''