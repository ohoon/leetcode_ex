/*
2379.
Minimum Recolors to Get K Consecutive Black Blocks
https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
*/

class Solution {
    public int minimumRecolors(String blocks, int k) {      // sliding window
        int white = 0;
        for (int i = 0; i < k; i++) {           // k 길이의 window
            if (blocks.charAt(i) == 'W') {
                white++;
            }
        }
        
        int answer = white;
        for (int i = k; i < blocks.length(); i++) {     // window를 한 칸씩 이동
            if (blocks.charAt(i) == 'W') {
                white++;
            }
            
            if (blocks.charAt(i-k) == 'W') {
                white--;
            }
            
            answer = Math.min(answer, white);
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 70.00% of Java online submissions for Minimum Recolors to Get K Consecutive Black Blocks.
Memory Usage: 42.2 MB, less than 20.00% of Java online submissions for Minimum Recolors to Get K Consecutive Black Blocks.
*/
