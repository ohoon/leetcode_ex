/*
5.
Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/
*/

class Solution {
    public String longestPalindrome(String s) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            int len1 = check(s, i, i);              // 한 글자에서 탐색 시작
            int len2 = check(s, i, i + 1);          // 두 글자에서 탐색 시작
            if (len1 > len2) {
                if (len1 > answer.length()) {
                    int offset = len1 / 2;
                    answer = s.substring(i - offset, i + offset + 1);
                }
            } else {
                if (len2 > answer.length()) {
                    int offset = (len2 / 2) - 1;
                    answer = s.substring(i - offset, i + offset + 2);
                }
            }
        }
        
        return answer;
    }
    
    public int check(String s, int left, int right) {           // DP 방식으로 한 글자 또는 두 글자에서 시작하여 점차 넓혀가며 Palindromic을 검증하는 함수
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {        // 가장 왼쪽 글자와 오른쪽 글자만 비교하면서 Palindromic 확장
            L--;
            R++;
        }
        
        return R - L - 1;
    }
}

/*
Runtime: 24 ms, faster than 79.37% of Java online submissions for Longest Palindromic Substring.
Memory Usage: 39.4 MB, less than 54.92% of Java online submissions for Longest Palindromic Substring.
*/

/*
최적 풀이

public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}

dp로 풀이해야하는 것은 감이 왔지만 실제로 어떻게 구현할지 조금 막막해서 풀이를 참고했다.
한번 흐름을 보고 내 나름대로 코드를 쳐봤는데, answer을 계속 substring해서 저장해서 실제 풀이보다 효율성이 떨어지게 나온 것 같다.
string으로 저장하는 것이 아닌 start와 end 인덱스를 기억해서 나중에 한번만 substring하여 제출하는 것으로 최적화하였다.

*/
