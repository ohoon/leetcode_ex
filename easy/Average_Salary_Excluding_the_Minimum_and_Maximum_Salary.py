'''
1491.
Average Salary Excluding the Minimum and Maximum Salary
https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
'''

class Solution:
    def average(self, salary: list[int]) -> float:
        total = 0
        maximum = salary[0]
        minimum = salary[0]
        for s in salary:
            total += s
            if s > maximum:     # 최대값 갱신
                maximum = s
                continue

            if s < minimum:     # 최소값 갱신
                minimum = s
                continue

        total -= maximum + minimum      # 최대값과 최소값을 제외한 합
        length = len(salary) - 2        # 최대값과 최소값을 제외한 총 개수

        return total / length

'''
Runtime: 32 ms, faster than 54.18% of Python3 online submissions for Average Salary Excluding the Minimum and Maximum Salary.
Memory Usage: 14.2 MB, less than 39.97% of Python3 online submissions for Average Salary Excluding the Minimum and Maximum Salary.
'''