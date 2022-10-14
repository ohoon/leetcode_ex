/*
1663.
Smallest String With A Given Numeric Value
https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
*/

class Solution {
    public String getSmallestString(int n, int k) {     // greedy
        char[] answer = new char[n];
        k -= n;
        for (int i = n-1; i >= 0; i--) {
            if (k >= 25) {
                answer[i] = 'z';
                k -= 25;
            } else {
                answer[i] = (char) ('a' + k);
                k = 0;
            }
        }
        
        return new String(answer);
    }
}

/*
Runtime: 13 ms, faster than 100.00% of Java online submissions for Smallest String With A Given Numeric Value.
Memory Usage: 42.3 MB, less than 95.82% of Java online submissions for Smallest String With A Given Numeric Value.
*/
