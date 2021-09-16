/*
1941.
Check if All Characters Have Equal Number of Occurrences
https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
*/

class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] occur = new int[26];
        int max = 0;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            max = Math.max(++occur[i], max);        // 해당 알파벳의 빈도수를 하나 올리고, 최대 빈도값인 max 갱신
        }
        
        for (int o : occur) {
            if (o > 0 && o != max) {                // 1번 이상의 빈도인 알파벳이 max와 같지 않다면 false 반환
                return false;
            }
        }
        
        return true;
    }
}

/*
Runtime: 2 ms, faster than 72.66% of Java online submissions for Check if All Characters Have Equal Number of Occurrences.
Memory Usage: 39.4 MB, less than 18.66% of Java online submissions for Check if All Characters Have Equal Number of Occurrences.
*/
