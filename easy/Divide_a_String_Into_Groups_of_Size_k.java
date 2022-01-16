/*
2138.
Divide a String Into Groups of Size k
https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
*/

class Solution {
    private String fillString(String s, int size, char fill) {      // 지정된 size 범위 안에서 fill로 여백을 채우는 메서드
        int n = s.length();
        if (n == size) {
            return s;
        }
        
        char[] fills = new char[size-n];
        for (int i = 0; i < size - n; i++) {
            fills[i] = fill;
        }
        
        return s + new String(fills);
    }
    
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int m = (n-1)/k + 1;
        String[] answer = new String[m];
        for (int i = 0; i < n-k; i += k) {          // fill로 채울 필요가 없는 부분 작업
            answer[i/k] = s.substring(i, i+k);
        }
        
        answer[m-1] = fillString(s.substring((m-1)*k), k, fill);        // 마지막 부분은 여백이 있을 경우 fill 문자로 채움
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Divide a String Into Groups of Size k.
Memory Usage: 38.8 MB, less than 100.00% of Java online submissions for Divide a String Into Groups of Size k.
*/
