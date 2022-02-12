/*
1910.
Remove All Occurrences of a Substring
https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
*/

class Solution {
    public String removeOccurrences(String s, String part) {
        int n = part.length();
        int idx = s.indexOf(part);
        while (idx > -1) {      // part가 s에 포함되지 않을 때까지 반복
            s = s.substring(0, idx) + s.substring(idx + n);     // s에서 part 제외
            idx = s.indexOf(part);  // 다시 s에 part가 포함되어 있는지 탐색
        }
        
        return s;
    }
}

/*
Runtime: 2 ms, faster than 83.70% of Java online submissions for Remove All Occurrences of a Substring.
Memory Usage: 43.3 MB, less than 27.55% of Java online submissions for Remove All Occurrences of a Substring.
*/
