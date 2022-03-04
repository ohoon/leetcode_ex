/*
1664.
Ways to Make a Fair Array
https://leetcode.com/problems/ways-to-make-a-fair-array/
*/

class Solution {
    public int waysToMakeFair(int[] nums) {
        int answer = 0, n = nums.length;
        if (n == 1) {       // 한 개만 제외하면 0 = 0으로 fair
            return 1;
        }
        
        int[][] arr = new int[n][2];
        arr[0][0] = nums[0];
        for (int i = 1; i < n; i++) {       // 각 인덱스 까지의 홀수, 짝수합을 누적시키며 arr에 기록
            if (i % 2 == 0) {
                arr[i][0] = arr[i-1][0] + nums[i];
                arr[i][1] = arr[i-1][1];
            } else {
                arr[i][0] = arr[i-1][0];
                arr[i][1] = arr[i-1][1] + nums[i];
            }
        }
        
        for (int i = 0; i < n; i++) {
            int Lx = arr[i][0], Ly = arr[i][1];     // i를 기준으로 좌우의 홀수, 짝수 합
            int Rx = arr[n-1][1] - arr[i][1], Ry = arr[n-1][0] - arr[i][0];
            if (i % 2 == 0) {       // i가 짝수 인덱스면 좌측 짝수 값을 감소시킴
                Lx -= nums[i];
            } else {                // 홀수의 경우는 반대로
                Ly -= nums[i];
            }
            
            int x = Lx + Rx, y = Ly + Ry;
            if (x == y) {       // fair하면 answer 증가
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 56 ms, faster than 6.55% of Java online submissions for Ways to Make a Fair Array.
Memory Usage: 108.6 MB, less than 36.75% of Java online submissions for Ways to Make a Fair Array.
*/
