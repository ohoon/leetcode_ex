/*
2037.
Minimum Number of Moves to Seat Everyone
https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
*/

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);             // seats와 students를 오름차순으로 정렬
        Arrays.sort(students);
        int answer = 0;
        for (int i = 0; i < seats.length; i++) {        // seat 번호가 가장 작은 seat부터 시작하여 가장 번호가 작은 student를 하나씩 배치해서 풀이
            answer += Math.abs(seats[i] - students[i]);
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Minimum Number of Moves to Seat Everyone.
Memory Usage: 38.8 MB, less than 66.67% of Java online submissions for Minimum Number of Moves to Seat Everyone.
*/
