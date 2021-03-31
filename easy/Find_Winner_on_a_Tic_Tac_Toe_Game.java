/*
1275.
Find Winner on a Tic Tac Toe Game
https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
*/

class Solution {
    public String tictactoe(int[][] moves) {
        int[] horizontal = new int[3];
        int[] vertical = new int[3];
        int[] diagonal = new int[2];
        int length = moves.length;
        for (int i = 0; i < length; i++) {
            int temp = 1;
            if (i % 2 != 0) {
                temp = -1;
            }
            
            horizontal[moves[i][0]] += temp;
            vertical[moves[i][1]] += temp;
            
            if (moves[i][0] == moves[i][1]) {
                diagonal[0] += temp;
            }
            
            if (moves[i][0] + moves[i][1] == 2) {
                diagonal[1] += temp;
            }
        }
        
        if ((length - 1) % 2 == 0) {
            if (IntStream.of(horizontal).anyMatch(x -> x == 3) ||
                IntStream.of(vertical).anyMatch(x -> x == 3) ||
                IntStream.of(diagonal).anyMatch(x -> x == 3)) {
                return "A";
            }
        } else {
            if (IntStream.of(horizontal).anyMatch(x -> x == -3) ||
                IntStream.of(vertical).anyMatch(x -> x == -3) ||
                IntStream.of(diagonal).anyMatch(x -> x == -3)) {
                return "B";
            }
        }
        
        if (length == 9) {
            return "Draw";
        }
        
        return "Pending";
    }
}

/*
Runtime: 3 ms, faster than 7.40% of Java online submissions for Find Winner on a Tic Tac Toe Game.
Memory Usage: 36.3 MB, less than 80.71% of Java online submissions for Find Winner on a Tic Tac Toe Game.
*/

/*
여담

속도는 퍼센트로 보면 낮게 나오지만 로직이 새로운 수에 초점이 맞추어 있기 때문에,
이미 놓여진 수로 승리를 판별하는 것이 아닌 실시간으로 한수 한수 둔다는 가정하에
속도는 그렇게 느리진 않을 것이라 예상된다. 그리고 다른 풀이보다는 코드가 간결하고 이해하기 쉽다고 생각함

*/
