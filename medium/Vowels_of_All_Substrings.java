/*
2063.
Vowels of All Substrings
https://leetcode.com/problems/vowels-of-all-substrings/
*/

class Solution {
    private boolean isVowel(char c) {       // 모음인지 체크하는 메서드
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public long countVowels(String word) {
        long answer = 0;
        int n = word.length();
        for(int i = 0; i < n; i++) {
            if(isVowel(word.charAt(i))) {       // 모음이 발견되면 그 이후의 substring에 1만큼 영향을 주므로 answer에 누적
                answer += (long) (n-i) * (i+1);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 16 ms, faster than 61.54% of Java online submissions for Vowels of All Substrings.
Memory Usage: 49.9 MB, less than 48.42% of Java online submissions for Vowels of All Substrings.
*/
