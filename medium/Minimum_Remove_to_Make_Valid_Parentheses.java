/*
1249.
Minimum Remove to Make Valid Parentheses
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
*/

class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();       // s를 char 배열로 변환
        Deque<Integer> deq = new LinkedList<>();        // 괄호 대칭 확인을 위해서 stack을 사용
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                deq.push(i);
                continue;
            }
            
            if (arr[i] == ')') {
                if (deq.isEmpty()) {        // 짝이 맞는 '(' 괄호가 없으면 해당 ')'는 삭제
                    arr[i] = '.';
                    continue;
                }
                
                deq.pop();              // 짝이 있으면 그대로 보존
            }
        }
        
        while (!deq.isEmpty()) {        // 제대로 닫히지 않은 괄호 쌍이 있으면 해당하는 '(' 괄호들을 삭제
            int idx = deq.pop();
            arr[idx] = '.';
        }
        
        return new String(arr).replace(".", "");        // 임시로 '.' 표시로 삭제한 괄호들을 완전히 없앰
    }
}

/*
Runtime: 25 ms, faster than 59.89% of Java online submissions for Minimum Remove to Make Valid Parentheses.
Memory Usage: 54.1 MB, less than 13.12% of Java online submissions for Minimum Remove to Make Valid Parentheses.
*/
