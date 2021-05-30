/*
1812.
Determine Color of a Chessboard Square
https://leetcode.com/problems/determine-color-of-a-chessboard-square/
*/

class Solution {
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) + coordinates.charAt(1)) % 2 != 0;    // a-z와 1-9의 아스키코드 합이 홀수면 흰색, 짝수면 검은색
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Determine Color of a Chessboard Square.
Memory Usage: 37 MB, less than 60.58% of Java online submissions for Determine Color of a Chessboard Square.
*/
