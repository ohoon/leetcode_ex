/*
2652.
Sum Multiples
https://leetcode.com/problems/sum-multiples/
*/

class Solution {
    public int sumOfMultiples(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                answer += i;
                continue;
            }
        }

        return answer;
    }
}
