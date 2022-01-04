/*
1647.
Minimum Deletions to Make Character Frequencies Unique
https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
*/

class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {        // 알파벳별로 카운팅
            freq[c - 'a']++;
        }
        
        Arrays.sort(freq);                      // 빈도수를 오름차순으로 정렬
        int keep = freq[25];                    // 조건을 만족하는 알파벳 빈도수들의 총합
        int prev = keep;                        // 바로 전의 빈도수
        for (int i = 24; i >= 0 && freq[i] != 0 && prev != 0; i--) {
            prev = Math.min(freq[i], prev - 1); // 바로 전의 빈도수 - 1와 현재 freq의 빈도수를 비교해서 더 낮은 것을 채택 
            keep += prev;                       // 빈도수를 누적
        }
        
        return s.length() - keep;
    }
}

/*
Runtime: 17 ms, faster than 43.94% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
Memory Usage: 51.9 MB, less than 16.43% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
*/
