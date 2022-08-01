/*
2125.
Number of Laser Beams in a Bank
https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
*/

class Solution {
    private int count(String str) {         // str에 있는 1의 개수를 반환하는 메서드
        int res = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') {
                res++;
            }
        }
        
        return res;
    }
    
    public int numberOfBeams(String[] bank) {
        int answer = 0, prev = 0;
        for (int i = 0; i < bank.length; i++) {
            int curr = count(bank[i]);
            if (curr == 0) {
                continue;
            }
            
            answer += prev * curr;          // 이전 보안장치와 현재 보안장치의 연결 가능한 경우의 수를 answer에 더해줌
            prev = curr;
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for 2 Keys Keyboard.
Memory Usage: 37.9 MB, less than 27.39% of Java online submissions for 2 Keys Keyboard.
*/
