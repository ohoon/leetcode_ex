/*
48.
Rotate Image
https://leetcode.com/problems/rotate-image/
*/

class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {               // 겉에 있는 껍데기부터 속까지 rotate를 진행
            for (int j = i; j < matrix[0].length-i-1; j++) {        // 각각의 껍데기에서 한 면의 원소들을 기준으로 rotate
                int[] temp = {
                    matrix[i][j],
                    matrix[j][matrix[0].length-i-1],
                    matrix[matrix.length-i-1][matrix[0].length-j-1],
                    matrix[matrix.length-j-1][i]
                };
                
                matrix[j][matrix[0].length-i-1] = temp[0];
                matrix[matrix.length-i-1][matrix[0].length-j-1] = temp[1];
                matrix[matrix.length-j-1][i] = temp[2];
                matrix[i][j] = temp[3];
            }
        }
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
Memory Usage: 38.5 MB, less than 99.12% of Java online submissions for Rotate Image.
*/

/*
다른 풀이

class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }
    
    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
    
    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}

대각을 기준으로 값을 swap하는 transpose와 y축을 기준으로 swap하는 reflect 과정을 거치면
90도 회전되는 것과 같아지는 성질을 이용한 풀이다.

*/
