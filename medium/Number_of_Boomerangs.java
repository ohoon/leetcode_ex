/*
447.
Number of Boomerangs
https://leetcode.com/problems/number-of-boomerangs/
*/

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                dist[i][j] = (int) (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
            }
        }

        int answer = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                int distA = dist[i][j];
                for (int k = j+1; k < n; k++) {
                    int distB = dist[i][k];
                    int distC = dist[j][k];
                    if (distA == distB || distA == distC || distB == distC) {
                        answer += 2;
                    }
                }
            }
        }

        return answer;
    }
}
