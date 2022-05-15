/*
2269.
Find the K-Beauty of a Number
https://leetcode.com/problems/find-the-k-beauty-of-a-number/
*/

class Solution {
    public int divisorSubstrings(int num, int k) {
        int answer = 0;
        String numStr = String.valueOf(num);        // string 타입으로 변환
        for (int i = 0; i <= numStr.length() - k; i++) {
            int divisor = Integer.valueOf(numStr.substring(i, i+k));    // 길이가 k인 블록으로 탐색
            if (divisor == 0) {
                continue;
            }
            
            if (num % divisor == 0) {       // 해당 블록이 조건을 만족하면 answer 증가
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 50.00% of Java online submissions for Find the K-Beauty of a Number.
Memory Usage: 40.6 MB, less than 100.00% of Java online submissions for Find the K-Beauty of a Number.
*/
