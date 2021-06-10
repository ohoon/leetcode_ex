/*
1869.
Longer Contiguous Segments of Ones than Zeros
https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/
*/

class Solution {
    public boolean checkZeroOnes(String s) {
        int one = 0, zero = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;        // 숫자 카운팅
            if (i == s.length() - 1 || s.charAt(i+1) != s.charAt(i)) {      // 숫자의 연속이 끝날 경우
                if (s.charAt(i) == '1') {           // 1의 경우 처리
                    one = Math.max(count, one);
                    count = 0;
                } else {                            // 0의 경우 처리
                    zero = Math.max(count, zero);
                    count = 0;
                }
            }
        }

        return one > zero;
    }
}

/*
Runtime: 1 ms, faster than 66.57% of Java online submissions for Longer Contiguous Segments of Ones than Zeros.
Memory Usage: 38.7 MB, less than 29.84% of Java online submissions for Longer Contiguous Segments of Ones than Zeros.
*/
