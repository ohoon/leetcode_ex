/*
1551.
Minimum Operations to Make Array Equal
https://leetcode.com/problems/minimum-operations-to-make-array-equal/
*/

class Solution {
    public int minOperations(int n) {
        int answer = 0;
        for (int i = 1; i < n; i += 2) {        // 홀수집합인 arr의 평균값은 n과 같으므로 [1, 3, ..., n]까지만 탐색하면 됨
            answer += n - i;                    // arr의 모든 요소를 평균값 n으로 만들어야 하므로 n-i만큼 연산이 이루어짐
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 41.10% of Java online submissions for Minimum Operations to Make Array Equal.
Memory Usage: 37.8 MB, less than 34.94% of Java online submissions for Minimum Operations to Make Array Equal.
*/
