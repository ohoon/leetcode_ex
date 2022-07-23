/*
1769.
Minimum Number of Operations to Move All Balls to Each Box
https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
*/

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] left = new int[n];        // 좌 -> 우 누적 operation 값 기록
        int[] right = new int[n];       // 좌 <- 우 누적 operation 값 기록
        int sum = 0, count = 0;
        for (int i = 0; i < n; i++) {       // left 배열 계산
            left[i] += sum;
            if (boxes.charAt(i) == '1') {
                count++;
            }
            
            sum += count;
        }
        
        sum = 0;
        count = 0;
        for (int i = n-1; i >= 0; i--) {        // right 배열 계산
            right[i] += sum;
            if (boxes.charAt(i) == '1') {
                count++;
            }
            
            sum += count;
        }
        
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {       // merge
            answer[i] = left[i] + right[i];
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 95.29% of Java online submissions for Minimum Number of Operations to Move All Balls to Each Box.
Memory Usage: 47.6 MB, less than 41.22% of Java online submissions for Minimum Number of Operations to Move All Balls to Each Box.
*/
