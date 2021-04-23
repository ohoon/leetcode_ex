'''
1507.
Reformat Date
https://leetcode.com/problems/reformat-date/
'''

class Solution:
    def reformatDate(self, date: str) -> str:
        monthMapper = {"Jan": "01", "Feb": "02", "Mar": "03", "Apr": "04", "May": "05", "Jun": "06",
                       "Jul": "07", "Aug": "08", "Sep": "09", "Oct": "10", "Nov": "11", "Dec": "12"}
        split = date.split()
        year = split[2]
        month = monthMapper[split[1]]
        day = split[0][:-2] if int(split[0][:-2]) >= 10 else ("0" + split[0][:-2])  # day가 10미만이면 앞에 0을 붙여줌

        return '-'.join([year, month, day])

'''
Runtime: 32 ms, faster than 51.63% of Python3 online submissions for Reformat Date.
Memory Usage: 14.1 MB, less than 94.26% of Python3 online submissions for Reformat Date.
'''

'''
여담

정규식이나 date 관련 함수를 사용하면 간편하게 풀 수 있는 문제지만
코딩 연습엔 도움이 되지 않을 것 같아 지양했다.
개인적으로 이런 노가다 문제는 좋아하지 않음...

'''