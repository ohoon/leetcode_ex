/*
1556.
Thousand Separator
https://leetcode.com/problems/three-consecutive-odds/
*/

class Solution {
    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        do {
            if (sb.length() > 0 && count % 3 == 0) {
                sb.append('.');
            }
            
            sb.append(n % 10);
            count++;
            n /= 10;
        } while (n > 0);
        
        return sb.reverse().toString();
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Thousand Separator.
Memory Usage: 36.2 MB, less than 61.44% of Java online submissions for Thousand Separator.
*/
