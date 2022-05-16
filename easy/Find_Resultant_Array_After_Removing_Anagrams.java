/*
2273.
Find Resultant Array After Removing Anagrams
https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
*/

class Solution {
    private boolean isAnagram(int[][] freq, int indexA, int indexB) {       // 두 단어의 알파벳 빈도수를 비교해서 애너그램 관계인지 판별하는 메서드
        for (int i = 0; i < 26; i++) {
            if (freq[indexA][i] != freq[indexB][i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public List<String> removeAnagrams(String[] words) {
        int[][] freq = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {        // 알파벳 빈도수 측정
            for (char c : words[i].toCharArray()) {
                freq[i][c - 'a']++;
            }
        }
        
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("-")) {         // -인 것은 작업하지 않음
                continue;
            }
            
            for (int j = i+1; j < words.length; j++) {
                if (!isAnagram(freq, i, j)) {
                    break;
                }
                
                words[j] = "-";     // 애너그램인 단어는 -으로 대체
            }
            
            answer.add(words[i]);
        }
        
        return answer;
    }
}

/*
Runtime: 4 ms, faster than 50.00% of Java online submissions for Find Resultant Array After Removing Anagrams.
Memory Usage: 46 MB, less than 25.00% of Java online submissions for Find Resultant Array After Removing Anagrams.
*/
