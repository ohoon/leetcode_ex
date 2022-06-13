/*
2299.
Strong Password Checker II
https://leetcode.com/problems/strong-password-checker-ii/
*/

class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {        // 길이 체크
            return false;
        }
        
        boolean lowerCheck = false, upperCheck = false;
        boolean digitCheck = false, specialCheck = false;
        String specialCharacters = "!@#$%^&*()-+";
        for (int i = 0; i < password.length(); i++) {
            if (i > 0 && password.charAt(i-1) == password.charAt(i)) {      // 인접한 문자가 동일한지 검사
                return false;
            }
            
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) {     // 소문자 체크
                lowerCheck = true;
                continue;
            }
            
            if (Character.isUpperCase(c)) {     // 대문자 체크
                upperCheck = true;
                continue;
            }
            
            if (Character.isDigit(c)) {         // 숫자 체크
                digitCheck = true;
                continue;
            }
            
            if (specialCharacters.indexOf(c) > -1) {        // 특수문자 체크
                specialCheck = true;
                continue;
            }
        }
        
        return lowerCheck && upperCheck && digitCheck && specialCheck;
    }
}

/*
Runtime: 1 ms, faster than 88.64% of Java online submissions for Strong Password Checker II.
Memory Usage: 41.6 MB, less than 75.00% of Java online submissions for Strong Password Checker II.
*/
