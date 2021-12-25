/*
1456.
Maximum Number of Vowels in a Substring of Given Length
https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
*/

class Solution {
    private boolean isVowel(char c) {       // 모음인지 확인하는 메서드
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    public int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {       // 0~k에서 모음 개수를 count에 저장
            char c = s.charAt(i);
            if (!isVowel(c)) {
                continue;
            }
            
            count++;
        }
        
        int answer = count;
        for (int i = 1; i <= s.length()-k; i++) {       // sliding window으로 window에서 제거되는 요소와 추가되는 요소만 체크하여 count를 관리
            char L = s.charAt(i-1);
            char R = s.charAt(i+k-1);
            if (isVowel(L)) {
                count--;
            }
            
            if (isVowel(R)) {
                count++;
            }
            
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
}

/*
Runtime: 9 ms, faster than 82.47% of Java online submissions for Maximum Number of Vowels in a Substring of Given Length.
Memory Usage: 39.3 MB, less than 90.56% of Java online submissions for Maximum Number of Vowels in a Substring of Given Length.
*/
