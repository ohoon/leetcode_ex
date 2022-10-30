/*
2451.
Odd String Difference
https://leetcode.com/problems/odd-string-difference/
*/

class Solution {
    public String oddString(String[] words) {
        int n = words.length, k = words[0].length();
        int[][] arr = new int[n][k-1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k-1; j++) {
                arr[i][j] = words[i].charAt(j+1) - words[i].charAt(j);
            }
        }
        
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < k-1; j++) {
                if (arr[i][j] != arr[i+1][j] && arr[i][j] != arr[i+2][j]) {
                    return words[i];
                }
                
                if (arr[i+1][j] != arr[i][j] && arr[i+1][j] != arr[i+2][j]) {
                    return words[i+1];
                }
                
                if (arr[i+2][j] != arr[i][j] && arr[i+2][j] != arr[i+1][j]) {
                    return words[i+2];
                }
            }
        }
        
        return "";
    }
}

/*
Runtime: 7 ms, faster than 16.67% of Java online submissions for Odd String Difference.
Memory Usage: 41.8 MB, less than 66.67% of Java online submissions for Odd String Difference.
*/
