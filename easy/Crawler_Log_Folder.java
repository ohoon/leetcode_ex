/*
1598.
Crawler Log Folder
https://leetcode.com/problems/crawler-log-folder/
*/

class Solution {
    public int minOperations(String[] logs) {
        int answer = 0;
        for (String log : logs) {
            if (log.equals("../")) {                // 상위 폴더인 경우, answer 감소 (0보다 작아지진 않음)
                answer = Math.max(answer - 1, 0);
            } else if (log.equals("./")) {          // 현재 폴더인 경우는 무시
                continue;
            } else {                                // 하위 폴더인 경우, answer 증가
                answer += 1;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 76.25% of Java online submissions for Crawler Log Folder.
Memory Usage: 38.3 MB, less than 82.00% of Java online submissions for Crawler Log Folder.
*/

/*
다른 사람의 풀이

class Solution {
    public int minOperations(String[] logs) {
         var stack = new Stack<String>();
        for(var log : logs){
            if(log.equals("../")){
                if(!stack.empty())
                    stack.pop();
            }else if(log.equals("./")){

            }else{
                stack.push(log);
            }
        }
        return stack.size();
    }
}

스택을 이용한 풀이다.
사실 디렉토리 탐색할때도 히스토리를 스택에 저장하여 뒤로가고 앞으로가기 때문에
같은 기능을 구현하려면 스택이 최적일 듯 싶다.

*/
