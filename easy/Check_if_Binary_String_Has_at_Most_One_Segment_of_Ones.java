/*
1784.
Check if Binary String Has at Most One Segment of Ones
https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
*/

class Solution {
    public boolean checkOnesSegment(String s) {
        boolean end = false;                    // 1의 나열이 끝난 상태.
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {           // 0이 나온 시점에 1은 모두 나왔다고 가정
                end = true;
            }

            if (end && s.charAt(i) == '1') {    // end 상태에도 불구하고 또다른 1이 나오면 false 반환
                return false;
            }
        }

        return true;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Check if Binary String Has at Most One Segment of Ones.
Memory Usage: 36.7 MB, less than 92.33% of Java online submissions for Check if Binary String Has at Most One Segment of Ones.
*/
