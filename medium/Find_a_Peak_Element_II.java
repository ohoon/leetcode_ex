/*
1901.
Find a Peak Element II
https://leetcode.com/problems/find-a-peak-element-ii/
*/

class Solution {
    public int[] findPeakGrid(int[][] mat) {        // greedy
        int m = mat.length, n = mat[0].length;
        int r = 0, c = 0;
        while (true) {
            int up = r > 0 ? mat[r-1][c] : -2;
            int down = r < m-1 ? mat[r+1][c] : -2;
            int left = c > 0 ? mat[r][c-1] : -2;
            int right = c < n-1 ? mat[r][c+1] : -2;
            if (mat[r][c] > up && mat[r][c] > down && mat[r][c] > left && mat[r][c] > right) {      // peak일 경우 break
                break;
            }

            if (up >= down && up >= left && up >= right) {          // 4방향 중 가장 큰 곳으로 이동
                r--;
                continue;
            }

            if (down >= up && down >= left && down >= right) {
                r++;
                continue;
            }

            if (left >= up && left >= right && left >= down) {
                c--;
                continue;
            }

            c++;
        }

        return new int[]{r, c};
    }
}
