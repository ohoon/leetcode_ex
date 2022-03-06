/*
2194.
Cells in a Range on an Excel Sheet
https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/
*/

class Solution {
    public List<String> cellsInRange(String s) {
        List<String> answer = new ArrayList<>();
        char col1 = s.charAt(0);        // s로부터 시작 행/열번호와 끝 행/열번호를 추출
        char col2 = s.charAt(3);
        char row1 = s.charAt(1);
        char row2 = s.charAt(4);
        for (char c = col1; c <= col2; c++) {       // 행번호 우선으로 answer에 삽입
            for (char r = row1; r <= row2; r++) {
                answer.add("" + c + r);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 9 ms, faster than 80.00% of Java online submissions for Cells in a Range on an Excel Sheet.
Memory Usage: 47.8 MB, less than 20.00% of Java online submissions for Cells in a Range on an Excel Sheet.
*/
