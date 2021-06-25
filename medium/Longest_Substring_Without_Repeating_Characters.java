/*
3.
Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] table = new int[128];         // 아스키코드에 해당하는 버킷 저장공간
        int answer = 0;
        int start = 0;                      // substring의 시작 인덱스
        Arrays.fill(table, -1);             // 모든 버킷들을 -1으로 초기화
        for (int i = 0; i < s.length(); i++) {
            if (table[s.charAt(i)] >= start) {      // 이미 substring에 존재하는 인덱스인 경우
                answer = Math.max(answer, i - start);
                start = table[s.charAt(i)] + 1;     // 시작 인덱스를 중복 단어 다음 인덱스로 갱신
            }
            
            table[s.charAt(i)] = i;                 // 탐색된 단어들을 버킷에 기록
        }
        
        return Math.max(answer, s.length() - start);
    }
}

/*
Runtime: 3 ms, faster than 89.47% of Java online submissions for Longest Substring Without Repeating Characters.
Memory Usage: 39.2 MB, less than 58.17% of Java online submissions for Longest Substring Without Repeating Characters.
*/
