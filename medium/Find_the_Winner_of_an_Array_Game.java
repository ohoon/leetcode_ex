/*
1535.
Find the Winner of an Array Game
https://leetcode.com/problems/find-the-winner-of-an-array-game/
*/

class Solution {
    public int getWinner(int[] arr, int k) {
        int curr = arr[0];      // 현재 숫자
        int win = 0;            // 이긴 횟수
        for (int i = 1; i < arr.length; i++) {
            if (curr > arr[i]) {        // 현재 숫자가 더 크면 이긴 횟수 증가
                win++;
            } else {                    // 현재 숫자가 더 작으면 curr을 해당 숫자로 바꾸고 win을 1로 설정
                curr = arr[i];
                win = 1;
            }
            
            if (win == k) {             // 현재 숫자가 k만큼 이겼으면 현재 숫자를 반환
                return curr;
            }
        }
        
        return curr;                    // arr.length가 k보다 작으면 arr의 최대값이 정답
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Winner of an Array Game.
Memory Usage: 51.2 MB, less than 50.31% of Java online submissions for Find the Winner of an Array Game.
*/
