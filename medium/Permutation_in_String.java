/*
567.
Permutation in String
https://leetcode.com/problems/permutation-in-string/
*/

class Solution {
    private boolean isMatched(int[] f1, int[] f2) {     // 두 substring의 알파벳 빈도수가 같은지 검사하는 메서드
        for (int i = 0; i < 26; i++) {
            if (f1[i] != f2[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {       // sliding window
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        int size = s1.length();
        if (s2.length() < size) {
            return false;
        }
        
        for (int i = 0; i < size; i++) {        // s1의 빈도수와 s2의 첫 window 빈도수를 계산
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }
        
        if (isMatched(f1, f2)) {        // 첫 window에서 match되는지 검사
            return true;
        }
        
        for (int i = 1; i < s2.length() - size + 1; i++) {      // window에 새롭게 추가되는 알파벳과 없어지는 알파벳만 고려
            f2[s2.charAt(i-1) - 'a']--;
            f2[s2.charAt(i+size-1) - 'a']++;
            if (isMatched(f1, f2)) {
                return true;
            }
        }
        
        return false;
    }
}

/*
Runtime: 5 ms, faster than 86.16% of Java online submissions for Permutation in String.
Memory Usage: 43.5 MB, less than 32.52% of Java online submissions for Permutation in String.
*/
