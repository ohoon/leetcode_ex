/*
1304.
Find N Unique Integers Sum up to Zero
https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
*/

class Solution {
    public int[] sumZero(int n) {
        int[] answer = new int[n];
        for (int i = 0; i < n - 1; i = i + 2) {     // 마지막을 제외한 짝수번째 인덱스마다 (i+1), -(i+1)값을 삽입
            answer[i] = i + 1;
            answer[i+1] = - i - 1;
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find N Unique Integers Sum up to Zero.
Memory Usage: 37.4 MB, less than 48.52% of Java online submissions for Find N Unique Integers Sum up to Zero.
*/
