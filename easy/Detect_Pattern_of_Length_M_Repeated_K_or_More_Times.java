/*
1566.
Detect Pattern of Length M Repeated K or More Times
https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/
*/

class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i <= arr.length - m * k; i++) {
            boolean correct = true;
            for (int j = 0; j < m; j++) {
                int cur = i + j;
                for (int l = 0; l < k; l++) {
                    int target = cur + m * l;
                    if (arr[cur] != arr[target]) {
                        correct = false;
                        break;
                    }
                }
                
                if (!correct) {
                    break;
                }
            }
            
            if (correct) {
                return true;
            }
        }
        
        return false;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Detect Pattern of Length M Repeated K or More Times.
Memory Usage: 36.3 MB, less than 88.36% of Java online submissions for Detect Pattern of Length M Repeated K or More Times.
*/
