'''
38.
Count and Say
https://leetcode.com/problems/count-and-say/
'''

class Solution:
    def countAndSay(self, n: int) -> str:
        seq = "1"
        stage = 1
        
        while stage < n:
            length = len(seq)
            buffer = ""
            count = 0
            
            for i in range(length):
                count += 1
                
                if i == length - 1 or seq[i] != seq[i + 1]:         # i가 마지막 인덱스이거나 같은 값 반복이 끝날 때
                    buffer += str(count) + seq[i]
                    count = 0
            
            seq = buffer        # buffer값을 다음 스테이지의 seq로
            stage += 1
            
        return seq
        

'''
Runtime: 40 ms, faster than 31.86% of Python3 online submissions for Count and Say.
Memory Usage: 14.3 MB, less than 99.96% of Python3 online submissions for Count and Say.
'''