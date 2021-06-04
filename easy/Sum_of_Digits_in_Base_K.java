/*
1837.
Sum of Digits in Base K
https://leetcode.com/problems/sum-of-digits-in-base-k/
*/

class Solution {
    public int sumBase(int n, int k) {
        int answer = 0;
        while (n > 0) {         // n진법으로 변환한 각각의 자리 수에 들어갈 값을 answer에 더해줌
            answer += n % k;
            n /= k;
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Digits in Base K.
Memory Usage: 35.6 MB, less than 81.55% of Java online submissions for Sum of Digits in Base K.
*/
