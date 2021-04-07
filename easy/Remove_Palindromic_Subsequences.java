/*
1332.
Remove Palindromic Subsequences
https://leetcode.com/problems/remove-palindromic-subsequences/
*/

class Solution {
    public int removePalindromeSub(String s) {
        int size = s.length();
        if (size == 0) {
            return 0;
        }
        
        for (int i = 0; i < (size / 2); i++) {
            int j = size - i - 1;
            if (s.charAt(i) != s.charAt(j)) {       // s가 완전한 대칭문자면 2반환
                return 2;
            }
        }
        
        return 1;                                   // s가 완전한 대칭문자가 아니면 a만 뽑고, b만 뽑는 것으로 대칭문자 성립
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Palindromic Subsequences.
Memory Usage: 36.8 MB, less than 49.34% of Java online submissions for Remove Palindromic Subsequences.
*/

/*
여담

subsequence라는 의미를 잘못 이해해서 풀이하는데 어려움을 많이 겪은 것 같다.
다른 사람의 풀이를 보고 subsequence가 비연속적인 숫자들의 집합임을 알았고 문제의 요점을 금방 이해했다.
다음에 풀이할 때는 문제의 요점을 잘 캐치해서 생각해야할듯

*/
