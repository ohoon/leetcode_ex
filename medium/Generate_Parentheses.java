/*
22.
Generate Parentheses
https://leetcode.com/problems/generate-parentheses/
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        int open = n, close = 0;            // 남은 열린 괄호와 닫힌 괄호 개수
        generate(answer, open, close, "");  // open과 close를 조절하며 괄호를 조합하는 메서드
        return answer;
    }
    
    public void generate(List<String> answer, int open, int close, String result) {
        if (open == 0 && close == 0) {      // 남은 괄호가 없으면 result를 answer에 추가하고 종료
            answer.add(result);
            return;
        }
        
        if (open > 0) {                     // 남은 열린 괄호가 있으면 result에 열린 괄호를 추가하고 open 감소, close 증가
            generate(answer, open - 1, close + 1, result + "(");
        }
        
        if (close > 0) {                    // 남은 닫힌 괄호가 있으면 result에 닫힌 괄호를 추가하고 close 감소
            generate(answer, open, close - 1, result + ")");
        }
    }
}

/*
Runtime: 1 ms, faster than 71.85% of Java online submissions for Generate Parentheses.
Memory Usage: 39.3 MB, less than 42.49% of Java online submissions for Generate Parentheses.
*/
