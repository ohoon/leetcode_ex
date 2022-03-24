/*
2033.
Minimum Operations to Make a Uni-Value Grid
https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/
*/

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m*n];
        for (int i = 0; i < m; i++) {       // 1차원 배열로 변환
            for (int j = 0; j < n; j++) {
                arr[i*n+j] = grid[i][j];
            }
        }
        
        Arrays.sort(arr);       // 오름차순 정렬
        int answer = 0;
        int target = arr[arr.length/2];     // 가운데 값을 기준으로 통일시킴
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diff = Math.abs(target - grid[i][j]);
                if (diff % x != 0) {        // x를 이용해서 목표값을 만들 수 없는 경우 -1 반환
                    return -1;
                }
                
                answer += diff / x;         // 연산 횟수를 answer에 
            }
        }
        
        return answer;
    }
}

/*
Runtime: 62 ms, faster than 56.46% of Java online submissions for Minimum Operations to Make a Uni-Value Grid.
Memory Usage: 123.2 MB, less than 46.50% of Java online submissions for Minimum Operations to Make a Uni-Value Grid.
*/
