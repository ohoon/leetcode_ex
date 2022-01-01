/*
1881.
Maximum Value after Insertion
https://leetcode.com/problems/maximum-value-after-insertion/
*/

class Solution {
    public String maxValue(String n, int x) {
        char m = (char) ('0' + x);      // x를 char형으로 변경
        if (n.charAt(0) == '-') {       // 음수인 경우
            for (int i = 1; i < n.length(); i++) {      // 앞자리부터 시작해서 x보다 큰 숫자가 나오면 해당 숫자 앞에 x를 삽입
                if (n.charAt(i) > m) {
                    return n.substring(0, i) + m + n.substring(i, n.length());
                }
            }
        } else {                        // 양수인 경우
            for (int i = 0; i < n.length(); i++) {      // 앞자리부터 시작해서 x보다 작은 숫자가 나오면 해당 숫자 앞에 x를 삽입
                if (n.charAt(i) < m) {
                    return n.substring(0, i) + m + n.substring(i, n.length());
                }
            }
        }
        
        return n + m;       // x가 가장 작은 숫자면 마지막에 삽입
    }
}

/*
Runtime: 11 ms, faster than 73.51% of Java online submissions for Maximum Value after Insertion.
Memory Usage: 40.2 MB, less than 36.36% of Java online submissions for Maximum Value after Insertion.
*/
