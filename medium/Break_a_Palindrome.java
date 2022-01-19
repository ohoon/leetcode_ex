/*
1328.
Break a Palindrome
https://leetcode.com/problems/break-a-palindrome/
*/

class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) {       // 1글자일 경우 무조건 palindrome이므로 빈 문자열을 반환
            return new String();
        }
        
        for (int i = 0; i < n/2; i++) {
            if (palindrome.charAt(i) != 'a') {      // 앞에서부터 a가 아닌 알파벳이 오면 a로 치환하여 반환
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i+1);
            }
        }
        
        return palindrome.substring(0, n-1) + 'b';  // 문자열이 aa...aa인 경우에 가장 사전적 순서가 빠른 aa...ab로 변경하여 반환
    }
}

/*
Runtime: 7 ms, faster than 5.82% of Java online submissions for Break a Palindrome.
Memory Usage: 39.5 MB, less than 5.41% of Java online submissions for Break a Palindrome.
*/
