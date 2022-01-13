/*
1930.
Unique Length-3 Palindromic Subsequences
https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
*/

class Solution {
    public int countPalindromicSubsequence(String s) {
        int answer = 0;
        int n = s.length();
        boolean[] alpha = new boolean[26];      // 각 알파벳별로 한번만 작업하기 위함
        for (int L = 0; L <= n-3; L++) {        // 왼쪽 부분
            if (alpha[s.charAt(L) - 'a']) {         // 이미 작업한 알파벳은 패스
                continue;
            }
            
            alpha[s.charAt(L) - 'a'] = true;
            for (int R = n-1; R >= L+2; R--) {              // 오른쪽 부분
                if (s.charAt(L) == s.charAt(R)) {           // 왼쪽 부분과 오른쪽 부분이 같아야 palindromic함
                    answer += s.substring(L+1, R).chars().distinct().count();       // 가운데 부분에는 어떤 알파벳이 와도 되므로 L과 R 사이 알파벳 개수를 answer에 더해줌
                    break;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 579 ms, faster than 16.23% of Java online submissions for Unique Length-3 Palindromic Subsequences.
Memory Usage: 51.6 MB, less than 18.32% of Java online submissions for Unique Length-3 Palindromic Subsequences.
*/

/*
여담

L과 R 사이에 중복을 제외한 알파벳 개수를 구하는 과정에서
set를 써야하나 고민이 됐는데 자바 최신 문법을 이용하면 보다 간단하게 구현할 수 있었다.
chars()로 문자열을 문자들로 쪼갠 후에 distinct()와 count()로 고유 알파벳 개수를 알아낼 수 있다.

*/
