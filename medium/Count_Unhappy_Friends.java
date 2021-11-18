/*
1583.
Count Unhappy Friends
https://leetcode.com/problems/count-unhappy-friends/
*/

class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int answer = 0;
        int[] p = new int[n];               // 2차원 배열인 pairs를 1차원 배열 p로 변환
        for (int i = 0; i < n/2; i++) {     // i의 짝 = p[i]
            p[pairs[i][0]] = pairs[i][1];
            p[pairs[i][1]] = pairs[i][0];
        }
        
        for (int i = 0; i < n; i++) {
            boolean isUnhappy = false;
            for (int j = 0; j < n-1; j++) {
                int target = preferences[i][j];
                if (target == p[i]) {               // 짝을 만날때까지 preferences[i]를 탐색
                    break;
                }
                
                for (int k = 0; k < n-1; k++) {     // target의 prefrence를 탐색
                    if (preferences[target][k] == p[target]) {      // target의 짝을 만날때까지 preferences[target]을 탐색
                        break;
                    }
                    
                    if (preferences[target][k] == i) {              // target의 짝보다 i를 더 좋아할 경우 i는 unhappy
                        isUnhappy = true;
                        break;
                    }
                }
                
                if (isUnhappy) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 92.33% of Java online submissions for Count Unhappy Friends.
Memory Usage: 54.8 MB, less than 99.08% of Java online submissions for Count Unhappy Friends.
*/
