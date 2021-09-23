/*
1974.
Minimum Time to Type Word Using Special Typewriter
https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/
*/

class Solution {
    public int minTimeToType(String word) {
        int answer = 0;
        char p = 'a';       // 현재 포인터가 가리키는 알파벳
        for (char c : word.toCharArray()) {
            answer += move(p, c) + 1;       // p에서 c로 이동한 횟수 + 선택하는 횟수
            p = c;                          // 포인터 갱신
        }
        
        return answer;
    }
    
    private int move(char a, char b) {
        if (a > b) {            // a <= b가 되도록 세팅
            char temp = a;
            a = b;
            b = temp;
        }
        
        return Math.min(b - a, (a - 'a') + ('z' - b) + 1);      // 시계방향과 반시계방향 거리 중, 이동 거리가 더 짧은 방향 선택
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Time to Type Word Using Special Typewriter.
Memory Usage: 37.1 MB, less than 84.27% of Java online submissions for Minimum Time to Type Word Using Special Typewriter.
*/
