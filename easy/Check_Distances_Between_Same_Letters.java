/*
2399.
Check Distances Between Same Letters
https://leetcode.com/problems/check-distances-between-same-letters/
*/

class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] d = new int[26];
        for (int i = 0; i < s.length(); i++) {      // 인덱스 차이 
            char c = s.charAt(i);
            d[c-'a'] = i - d[c-'a'];
        }
        
        for (int i = 0; i < 26; i++) {
            if (d[i] != 0 && d[i] != distance[i] + 1) {
                return false;
            }
        }
        
        return true;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Check Distances Between Same Letters.
Memory Usage: 42.2 MB, less than 93.75% of Java online submissions for Check Distances Between Same Letters.
*/
