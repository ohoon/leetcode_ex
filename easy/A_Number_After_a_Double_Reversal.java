/*
2119.
A Number After a Double Reversal
https://leetcode.com/problems/a-number-after-a-double-reversal/
*/

class Solution {
    public boolean isSameAfterReversals(int num) {
        return num == 0 || num % 10 != 0;       // 0을 제외한 num이 0으로 끝나면 뒤집을 때, leading zero를 제거해야하므로 처음 모양과 달라지게 됨
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for A Number After a Double Reversal.
Memory Usage: 35.7 MB, less than 57.14% of Java online submissions for A Number After a Double Reversal.
*/
