/*
1886.
Determine Whether Matrix Can Be Obtained By Rotation
https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
*/

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int turn = 0; turn < 4; turn++) {
            if (Arrays.deepEquals(mat, target)) {       // mat와 target의 배열 원소들이 일치할 경우 true 반환
                return true;
            }
            
            for (int i = 0; i < (n + 1) / 2; i++) {     // i는 배열의 바깥부터 속까지의 깊이
                for (int j = i; j < n - i - 1; j++) {   // j는 배열의 i층의 한 변씩 탐색
                    int temp = mat[i][j];
                    mat[i][j] = mat[n-j-1][i];          // 각 원소를 90도씩 4번 돌리면서 값 이동
                    mat[n-j-1][i] = mat[n-i-1][n-j-1];
                    mat[n-i-1][n-j-1] = mat[j][n-i-1];
                    mat[j][n-i-1] = temp;
                }
            }
        }
        
        return false;
    }
}

/*
Runtime: 1 ms, faster than 72.32% of Java online submissions for Determine Whether Matrix Can Be Obtained By Rotation.
Memory Usage: 37.9 MB, less than 95.74% of Java online submissions for Determine Whether Matrix Can Be Obtained By Rotation.
*/

/*
여담

90도씩 회전하는 과정을 구현하는 문제이다.
원소가 이동할 위치를 어떻게 구할 것인가가 관건인 것 같다.
회전식을 생각하는데 조금 어려움이 있어서 힌트를 보면서 풀이했다.
다음에 다시 풀어서 머리에 익혀보자

*/
