/*
2549.
Count Distinct Numbers on Board
https://leetcode.com/problems/count-distinct-numbers-on-board/
*/

class Solution {
    public int distinctIntegers(int n) {
        return n > 1 ? n-1 : 1;     // 결국 n % n-1 == 1이므로 과정을 반복하면 2 ~ n이 나열됨
    }
}
