/*
1947.
Maximum Compatibility Score Sum
https://leetcode.com/problems/maximum-compatibility-score-sum/
*/

class Solution {
    private int getScore(int[] student, int[] mentor) {         // 학생과 멘토의 score 값을 반환하는 함수
        int score = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i] != mentor[i]) {
                continue;
            }
            
            score++;
        }
        
        return score;
    }
    
    private int sub(int[][] students, int[][] mentors, boolean[] isAssigned, int index, int score) {        // backtracking하며 완전 탐색
        if (index >= students.length) {
            return score;
        }
        
        int result = 0;
        for (int i = 0; i < mentors.length; i++) {
            if (isAssigned[i]) {        // 이미 할당된 멘토는 패스
                continue;
            }
            
            isAssigned[i] = true;
            result = Math.max(result,
                             sub(students,      // 현재 학생과 해당 멘토를 할당시키고 다음 학생으로 넘어감
                                 mentors,
                                 isAssigned,
                                 index + 1,
                                 score + getScore(students[index], mentors[i])));
            isAssigned[i] = false;
        }
        
        return result;
    }
    
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return sub(students, mentors, new boolean[students.length], 0, 0);
    }
}

/*
Runtime: 34 ms, faster than 61.89% of Java online submissions for Maximum Compatibility Score Sum.
Memory Usage: 37 MB, less than 58.74% of Java online submissions for Maximum Compatibility Score Sum.
*/
