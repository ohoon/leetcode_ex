/*
967.
Numbers With Same Consecutive Differences
https://leetcode.com/problems/numbers-with-same-consecutive-differences/
*/

class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Deque<Integer> deq = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {      // 1~9로 시작
            deq.add(i);
        }
        
        for (int i = 1; i < n; i++) {
            int size = deq.size();
            for (int j = 0; j < size; j++) {
                int num = deq.removeFirst();
                int lastDigit = num % 10;
                if (lastDigit + k < 10) {       // num의 일의 자리에서 +k, -k한 값을 끝자리에 더한 숫자를 다시 deq에 삽입
                    deq.add(num * 10 + (lastDigit + k));
                }
                
                if (k == 0) {       // +0 -0 중복 방지
                    continue;
                }
                
                if (lastDigit - k >= 0) {
                    deq.add(num * 10 + (lastDigit - k));
                }
            }
        }
        
        return deq.stream().mapToInt(v -> v).toArray();
    }
}

/*
Runtime: 11 ms, faster than 16.90% of Java online submissions for Numbers With Same Consecutive Differences.
Memory Usage: 43.2 MB, less than 39.61% of Java online submissions for Numbers With Same Consecutive Differences.
*/
