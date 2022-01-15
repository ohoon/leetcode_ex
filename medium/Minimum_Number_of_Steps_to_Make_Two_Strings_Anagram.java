/*
1347.
Minimum Number of Steps to Make Two Strings Anagram
https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
*/

class Solution {
    public int minSteps(String s, String t) {
        int answer = 0;
        int[] alphaX = new int[26];
        int[] alphaY = new int[26];
        for (int i = 0; i < s.length(); i++) {      // s와 t의 알파벳 개수 구하기
            alphaX[s.charAt(i) - 'a']++;
            alphaY[t.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (alphaX[i] > alphaY[i]) {            // s와 t의 알파벳 개수를 비교하면서 t보다 s에서 더 많은 알파벳 개수만큼 answer에 더해줌
                answer += alphaX[i] - alphaY[i];
            }
        }
        
        return answer;
    }
}

/*
Runtime: 13 ms, faster than 76.77% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
Memory Usage: 51.8 MB, less than 20.68% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
*/
