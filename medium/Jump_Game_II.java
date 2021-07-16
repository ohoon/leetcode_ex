/*
45.
Jump Game
https://leetcode.com/problems/jump-game-ii/
*/

class Solution {
    public int jump(int[] nums) {
        int answer = 0;
        int target = nums.length - 1;
        while (target > 0) {
            for (int i = 0; i < target; i++) {          // target에 도달할 수 있는 가장 작은 인덱스 탐색
                if (i + nums[i] >= target) {
                    target = i;                         // target 갱신하고 재탐색
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 13 ms, faster than 37.18% of Java online submissions for Jump Game II.
Memory Usage: 39.7 MB, less than 49.32% of Java online submissions for Jump Game II.
*/

/*
다른 사람의 풀이

class Solution {
    public int jump(int[] N) {
        int len = N.length - 1, curr = -1, next = 0, ans = 0;
        for (int i = 0; next < len; i++) {
            if (i > curr) {
                ans++;
                curr = next;
            };
            next = Math.max(next, N[i] + i);
        };
        return ans;
    };
};

0부터 시작하여 인덱스가 curr에 도달할때까지 next를 갱신하며 탐색하는 방법이다.
lastIndex에서 target을 지정해놓고 이중반복문으로 탐색하는 내 풀이와 다르게 처음부터 next를 갱신하여 O(N)으로 풀이하여 속도가 더 빠를 것이라 예상된다.

*/
