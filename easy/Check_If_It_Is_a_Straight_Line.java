/*
1232.
Check If It Is a Straight Line
https://leetcode.com/problems/check-if-it-is-a-straight-line/
*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) {      // 비교할 기울기가 하나 밖에 없을 경우 true 반환
            return true;
        }
        
        for (int i = 0; i < coordinates.length - 2; i++) {
            int[] first = coordinates[i];
            int[] second = coordinates[i+1];
            int[] third = coordinates[i+2];
            if ((first[0] - second[0]) * (second[1] - third[1]) != (second[0] - third[0]) * (first[1] - second[1])) {
                return false;       // (first <-> second의 기울기) == (second <-> third의 기울기)
            }
        }
        
        return true;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Check If It Is a Straight Line.
Memory Usage: 38.6 MB, less than 61.62% of Java online submissions for Check If It Is a Straight Line.
*/
