/*
1572.
Matrix Diagonal Sum
https://leetcode.com/problems/matrix-diagonal-sum/
*/

class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j == n - 1 || i == j) {     // 역슬래시에 해당하는 위치거나 슬래시에 해당하는 위치면 answer에 증가
                    answer += mat[i][j];
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 22.68% of Java online submissions for Matrix Diagonal Sum.
Memory Usage: 38.8 MB, less than 83.95% of Java online submissions for Matrix Diagonal Sum.
*/

/*
다른 사람의 풀이

class Solution {
    public int diagonalSum(int[][] mat) {
        
        int sum = 0;
        int n = mat.length;
        
        for(int i = 0; i < n; i++){
            sum += mat[i][i] + mat[i][n-i -1];
        }
        
        if(n % 2 != 0) sum -= mat[n/2][n/2];
        
        return sum;
    }
}

모든 행과 열을 탐색하는 것이 아닌 행만 탐색하면서 (i, i)인 경우와 그 반대 편의 값만 더하는 풀이다.
따라서 O(N*N)이 아닌 O(N)에 가까운 속도를 보여주는 멋진 풀이다.

*/
