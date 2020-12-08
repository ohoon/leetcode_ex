'''
551.
Student Attendance Record I
https://leetcode.com/problems/student-attendance-record-i/
'''

class Solution:
    def checkRecord(self, s: str) -> bool:
        absent = 0
        for i in range(len(s)):
            if i >= 2 and s[i] == 'L' and s[i-1] == 'L' and s[i-2] == 'L':      # L이 3번 연속해서 나오면 False
                return False
            
            if s[i] == 'A':                                                     # A가 2번 이상 나오면 False
                if absent > 0:
                    return False
                
                absent += 1

        return True

'''
Runtime: 28 ms, faster than 75.30% of Python3 online submissions for Student Attendance Record I.
Memory Usage: 14.2 MB, less than 15.13% of Python3 online submissions for Student Attendance Record I.
'''