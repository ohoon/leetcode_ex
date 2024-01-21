/*
2643.
Row With Maximum Ones
https://leetcode.com/problems/row-with-maximum-ones/
*/

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] answer = new int[]{-1, -1};
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }

            if (answer[1] < count) {
                answer = new int[]{i, count};
            }
        }

        return answer;
    }
}
