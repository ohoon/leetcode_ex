/*
916.
Word Subsets
https://leetcode.com/problems/word-subsets/
*/

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> answer = new ArrayList<>();
        int[][] freq1 = new int[words1.length][26];         // words1의 각 문자열 알파벳 빈도수를 나타낸 배열
        int[] freq2 = new int[26];                          // words2의 각 문자열들이 공통으로 요구하는 알파벳 빈도수를 나타낸 배열 (최소공배수와 비슷한 개념)
        for (int i = 0; i < words1.length; i++) {           // freq1 빈도수 쌓기
            for (int j = 0; j < words1[i].length(); j++) {
                freq1[i][words1[i].charAt(j) - 'a']++;
            }
        }
        
        for (int i = 0; i < words2.length; i++) {           // freq2 공통 빈도수 쌓기
            int[] temp = new int[26];           // 각 문자열별로 임시로 빈도수를 측정하기 위한 배열
            for (int j = 0; j < words2[i].length(); j++) {
                temp[words2[i].charAt(j) - 'a']++;
            }
            
            for (int k = 0; k < 26; k++) {      // 공통으로 요구하는 알파벳 빈도수를 구해야하므로 알파벳별 빈도수의 최대값이 freq2에 등록됨
                freq2[k] = Math.max(freq2[k], temp[k]);
            }
        }
        
        for (int i = 0; i < words1.length; i++) {       // freq1와 freq2를 비교하면서 freq1 빈도수가 freq2의 빈도수를 모두 만족하는지 검사
            boolean isSubset = true;
            for (int j = 0; j < 26; j++) {
                if (freq1[i][j] < freq2[j]) {
                    isSubset = false;
                    break;
                }
            }
            
            if (isSubset) {         // 조건이 성립하면 answer에 해당 문자열을 삽입
                answer.add(words1[i]);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 41 ms, faster than 40.79% of Java online submissions for Word Subsets.
Memory Usage: 83.6 MB, less than 53.29% of Java online submissions for Word Subsets.
*/
