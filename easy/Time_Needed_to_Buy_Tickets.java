/*
2073.
Time Needed to Buy Tickets
https://leetcode.com/problems/time-needed-to-buy-tickets/
*/

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int answer = 0;
        while (tickets[k] > 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {       // 남은 티켓 감수 감소
                    tickets[i]--;
                    answer++;
                }
                
                if (tickets[k] == 0) {      // k번째 사람의 남은 티켓 수가 0이 되면 반복문 종료
                    break;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 66.67% of Java online submissions for Time Needed to Buy Tickets.
Memory Usage: 36.6 MB, less than 88.89% of Java online submissions for Time Needed to Buy Tickets.
*/
