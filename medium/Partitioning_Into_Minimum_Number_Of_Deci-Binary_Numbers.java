/*
1689.
Partitioning Into Minimum Number Of Deci-Binary Numbers
https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
*/

class Solution {
    public int minPartitions(String n) {
        int answer = n.charAt(0) - '0';
        for (int i = 1; i < n.length(); i++) {      // n에서 가장 큰 숫자만큼 deci-binary를 빼게 됨 (4213의 경우 가장 작은 숫자인 1부터 시작해서 0을 만듬. 4213 -> 3102 -> 2001 -> 1000 -> 0000)
            answer = Math.max(answer, n.charAt(i) - '0');
        }
        
        return answer;
    }
}

/*
Runtime: 5 ms, faster than 82.42% of Java online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
Memory Usage: 39.6 MB, less than 75.78% of Java online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
*/
