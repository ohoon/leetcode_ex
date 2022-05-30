/*
2287.
Rearrange Characters to Make Target String
https://leetcode.com/problems/rearrange-characters-to-make-target-string/
*/

class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] freqS = new int[26];          // s에서의 알파벳 빈도수 배열
        int[] freqTarget = new int[26];     // target에서의 알파벳 빈도수 배열
        for (char c : s.toCharArray()) {    // 각 freq의 값 측정
            freqS[c-'a']++;
        }
        
        for (char c : target.toCharArray()) {
            freqTarget[c-'a']++;
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freqTarget[i] == 0) {       // target에 있는 알파벳만 작업
                continue;
            }
            
            int res = freqS[i] / freqTarget[i];     // 알파벳 단위로 s에서 target을 몇번 만들 수 있는지 나타내는 값
            if (res == 0) {     // target에 속한 어떤 알파벳이라도 s로 만들 수 없으면 0 반환하고 종료
                return 0;
            }
            
            answer = Math.min(answer, res);
        }
        
        return answer != Integer.MAX_VALUE ? answer : 0;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Rearrange Characters to Make Target String.
Memory Usage: 40.5 MB, less than 33.33% of Java online submissions for Rearrange Characters to Make Target String.
*/
