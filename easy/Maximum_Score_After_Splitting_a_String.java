/*
1422.
Maximum Score After Splitting a String
https://leetcode.com/problems/maximum-score-after-splitting-a-string/
*/

class Solution {
    public int maxScore(String s) {
        int count = 0;      // 모든 1의 개수
        int max_offset = Integer.MIN_VALUE;         // 최대 오프셋
        int offset = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {       // 0이면 +, 1이면 -
                offset++;
            } else {
                count++;
                offset--;
            }
            
            if (offset > max_offset) {      // 최대 오프셋 갱신
                max_offset = offset;
            }
        }
        
        if (s.charAt(s.length() - 1) == '1') {
            count++;
        }
        
        return count + max_offset;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Score After Splitting a String.
Memory Usage: 37.1 MB, less than 58.51% of Java online submissions for Maximum Score After Splitting a String.
*/
