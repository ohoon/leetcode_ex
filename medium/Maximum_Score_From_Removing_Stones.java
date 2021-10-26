/*
1753.
Maximum Score From Removing Stones
https://leetcode.com/problems/maximum-score-from-removing-stones/
*/

class Solution {
    public int maximumScore(int a, int b, int c) {
        int answer = 0;
        while (a > 0) {
            if (b == 0 && c == 0) {
                return answer;
            }
            
            answer++;
            a--;
            if (b > c) {            // b, c 중 큰 것과 a를 감소시키면서 카운팅
                b--;
            } else {
                c--;
            }
        }
        
        if (Math.min(b, c) != 0) {      // 남아있는 b, c을 감소시키며 카운팅
            answer += Math.min(b, c);
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 68.15% of Java online submissions for Maximum Score From Removing Stones.
Memory Usage: 36.2 MB, less than 76.03% of Java online submissions for Maximum Score From Removing Stones.
*/
