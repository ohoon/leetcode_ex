/*
498.
Diagonal Traverse
https://leetcode.com/problems/diagonal-traverse/
*/

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] answer = new int[m*n];
        int i = 0, j = 0;
        boolean dir = true;     // dir = true (↗), dir = false (↙)
        for (int idx = 0; idx < answer.length; idx++) {
            answer[idx] = mat[i][j];
            if (dir) {      // ↗일 때
                if (j == n-1) {
                    i++;
                    dir = false;
                    continue;
                }
                
                if (i == 0) {
                    j++;
                    dir = false;
                    continue;
                }
                
                i--;
                j++;
            } else {        // ↙일 때
                if (i == m-1) {
                    j++;
                    dir = true;
                    continue;
                }
                
                if (j == 0) {
                    i++;
                    dir = true;
                    continue;
                }
                
                i++;
                j--;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 75.62% of Java online submissions for Diagonal Traverse.
Memory Usage: 55.1 MB, less than 28.68% of Java online submissions for Diagonal Traverse.
*/
