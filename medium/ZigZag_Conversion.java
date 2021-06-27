/*
6.
ZigZag Conversion
https://leetcode.com/problems/zigzag-conversion/
*/

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {         // 지그재그할 필요가 없는 경우 그대로 반환
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int cur = i;
            boolean down = (i != numRows - 1);          // 마지막 row가 아닌 경우 내려갔다 올라오는 V부분부터 시작
            while (cur < s.length()) {
                sb.append(s.charAt(cur));
                
                if (down) {                             // V의 경우, row 끝부터 현재까지의 길이의 2배를 이동
                    cur += (numRows - i - 1) * 2;
                } else {                                // ^의 경우, 첫 row부터 현재까지의 길이의 2배를 이동
                    cur += i * 2;
                }
                
                if (i > 0 && i < numRows - 1) {         // 처음 또는 마지막 row의 경우에는 한가지 방향만 계산함
                    down = !down;
                }
            }
        }
        
        return sb.toString();
    }
}

/*
Runtime: 4 ms, faster than 83.42% of Java online submissions for ZigZag Conversion.
Memory Usage: 39.3 MB, less than 77.12% of Java online submissions for ZigZag Conversion.
*/
