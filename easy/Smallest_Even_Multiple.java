/*
2413.
Smallest Even Multiple
https://leetcode.com/problems/smallest-even-multiple/
*/

class Solution {
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : 2*n;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Smallest Even Multiple.
Memory Usage: 40.8 MB, less than 60.00% of Java online submissions for Smallest Even Multiple.
*/
