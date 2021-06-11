/*
1876.
Substrings of Size Three with Distinct Characters
https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
*/

class Solution {
    public int countGoodSubstrings(String s) {
        int answer = 0;

        if (s.length() < 3) {
            return 0;
        } else {
            for (int i = 2; i < s.length(); i++) {
                if (s.charAt(i-2) != s.charAt(i-1) && s.charAt(i-2) != s.charAt(i) && s.charAt(i-1) != s.charAt(i)) {
                    answer++;
                }
            }
        }

        return answer;
    }
}

/*
Runtime: 1 ms, faster than 87.25% of Java online submissions for Substrings of Size Three with Distinct Characters.
Memory Usage: 36.9 MB, less than 94.72% of Java online submissions for Substrings of Size Three with Distinct Characters.
*/
