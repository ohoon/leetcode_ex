/*
2405.
Optimal Partition of String
https://leetcode.com/problems/optimal-partition-of-string/
*/

class Solution {
    public int partitionString(String s) {
        int answer = 1;
        boolean[] freq = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)-'a']) {
                answer++;
                freq = new boolean[26];
            }
            
            freq[s.charAt(i)-'a'] = true;
        }
        
        return answer;
    }
}

/*
Runtime: 24 ms, faster than 82.25% of Java online submissions for Optimal Partition of String.
Memory Usage: 53.5 MB, less than 72.49% of Java online submissions for Optimal Partition of String.
*/
