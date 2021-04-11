/*
1374.
Generate a String With Characters That Have Odd Counts
https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
*/

class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i ++) {
            sb.append("x");
        }
        
        if (n % 2 != 0) {
            sb.append("x");
        } else {                // n이 짝수면 마지막에 x대신 y를 삽입
            sb.append("y");
        }
        
        return sb.toString();
    }
}

/*
Runtime: 1 ms, faster than 46.87% of Java online submissions for Generate a String With Characters That Have Odd Counts.
Memory Usage: 36.3 MB, less than 60.28% of Java online submissions for Generate a String With Characters That Have Odd Counts.
*/
