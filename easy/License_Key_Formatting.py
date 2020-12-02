'''
482.
License Key Formatting
https://leetcode.com/problems/license-key-formatting/
'''

class Solution:
    def licenseKeyFormatting(self, S: str, K: int) -> str:
        answer=''
        S = S.replace('-', '').upper()
        while S:
            if len(S) <= K:     # K개씩 나누고 남은 마지막 부분 처리
                answer = S + answer
                break
                
            answer = '-' + S[-K:] + answer      # answer 앞에 k개의 key set를 붙여줌
            S = S[:-K]
            
        return answer

'''
Runtime: 100 ms, faster than 22.87% of Python3 online submissions for License Key Formatting.
Memory Usage: 14.7 MB, less than 51.17% of Python3 online submissions for License Key Formatting.
'''

'''
다른 사람의 풀이

class Solution:
    def licenseKeyFormatting(self, S: str, K: int) -> str:
        S=S.replace("-","").upper() # remove "-" and covert string to uppercase
        remainder = len(S) % K      # calculate length of first group
										# For example:
										# remainder==1; k=3: 1-123-123-123
										# remainder==0; k=3: _-123-123-123 (blank)
										
        first_grp=[S[0:remainder]] # first group
        other_grps= [ S[i:i+K] for i in range(remainder,len(S),K) ] # other groups
        
        if  remainder: return "-".join(first_grp+other_grps)
		# first group is empty at this point
        return "-".join(other_grps)

나는 문자열 S를 뒤에서부터 K씩 추출해서 나머지 부분으로 S를 재정의하는 식으로 풀이했는데
여기서는 for을 이용해서 문자열 S에서 K개씩 탐색하여 배열로 만들고 join으로 -을 붙여주는 식으로 풀이했다.
아무래도 재정의하는 부분이 없다보니까 나의 풀이보다 효율성이 높을 것이라 예상된다.

'''