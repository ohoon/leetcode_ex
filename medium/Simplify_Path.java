/*
71.
Simplify Path
https://leetcode.com/problems/simplify-path/
*/

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] split = path.split("/");
        for (String p : split) {
            if (p.isEmpty() || p.equals(".")) {         // 현재 위치 유지
                continue;
            }
            
            if (p.equals("..")) {                       // 이전 위치로 이동 (stack.pop())
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
                
                continue;
            }
            
            stack.addLast(p);                           // 다음 위치로 이동 (stack.push())
        }
        
        return "/" + String.join("/", stack);
    }
}

/*
Runtime: 5 ms, faster than 55.17% of Java online submissions for Simplify Path.
Memory Usage: 39.1 MB, less than 67.43% of Java online submissions for Simplify Path.
*/
