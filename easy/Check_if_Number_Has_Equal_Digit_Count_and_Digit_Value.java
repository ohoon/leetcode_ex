/*
2119.
Check if Number Has Equal Digit Count and Digit Value
https://leetcode.com/problems/a-number-after-a-double-reversal/
*/

class Solution {
    public boolean digitCount(String num) {
        int[] freq = new int[10];
        for (char c : num.toCharArray()) {      // 빈도수 측정
            freq[c-'0']++;
        }
        
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) - '0' != freq[i]) {       // 조건에 맞지 않으면 false 반환하고 종료
                return false;
            }
        }
        
        return true;        // 모두 조건에 맞으면 true 반환
    }
}

/*
Runtime: 2 ms, faster than 28.57% of Java online submissions for Check if Number Has Equal Digit Count and Digit Value.
Memory Usage: 42.3 MB, less than 42.86% of Java online submissions for Check if Number Has Equal Digit Count and Digit Value.
*/
