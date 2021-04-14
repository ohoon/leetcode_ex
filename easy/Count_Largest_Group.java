/*
1399.
Check If It Is a Straight Line
https://leetcode.com/problems/count-largest-group/
*/

class Solution {
    public int countLargestGroup(int n) {
        int[] sum = new int[36];
        int max = 0;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = ++sum[calcDigitSum(i)-1];       // digit 합의 카운팅 횟수
            if (count > max) {                          // 최댓값보다 클 경우 갱신하고 answer 초기화
                max = count;
                answer = 1;
            } else if (count == max) {                  // 최댓값인 경우 answer 증가
                answer++;
            }
        }
        
        return answer;
    }
    
    private int calcDigitSum(int n) {           // digit의 합을 반환하는 함수
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n /= 10;
        }
        
        return result;
    }
}

/*
Runtime: 4 ms, faster than 73.92% of Java online submissions for Count Largest Group.
Memory Usage: 35.3 MB, less than 98.19% of Java online submissions for Count Largest Group.
*/
