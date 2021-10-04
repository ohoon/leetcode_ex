'''
2022.
Convert 1D Array Into 2D Array
https://leetcode.com/problems/convert-1d-array-into-2d-array/
'''

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m*n) {           // m x n 배열에 가득 차지 않는 original인 경우 빈 배열 반환
            return new int[0][0];
        }
        
        int[][] answer = new int[m][n];
        for (int i = 0; i < original.length; i++) {     // n열 기준으로 i/n으로 열을 정하고, i%n으로 행을 정함
            answer[i/n][i%n] = original[i];
        }
        
        return answer;
    }
}

'''
Runtime: 8 ms, faster than 20.00% of Java online submissions for Convert 1D Array Into 2D Array.
Memory Usage: 117.4 MB, less than 20.00% of Java online submissions for Convert 1D Array Into 2D Array.
'''
