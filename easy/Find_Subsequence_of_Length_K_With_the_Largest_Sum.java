/*
2099.
Find Subsequence of Length K With the Largest Sum
https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
*/

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] answer = new int[k];
        int[][] arr = new int[nums.length][2];      // nums를 [인덱스, 요소 값] 형태로 변환
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new int[]{i, nums[i]};
        }

        Arrays.sort(arr, (n1, n2) -> n2[1] - n1[1]);        // 요소 값을 기준으로 내림차순 정렬
        int[][] top = Arrays.copyOf(arr, k);                // k번째로 큰 요소까지만 추출
        Arrays.sort(top, (n1, n2) -> n1[0] - n2[0]);        // 인덱스를 기준으로 오름차순 정렬
        for (int i = 0; i < k; i++) {                       // answer 배열에 삽입
            answer[i] = top[i][1];
        }

        return answer;
    }
}

/*
Runtime: 6 ms, faster than 85.71% of Java online submissions for Find Subsequence of Length K With the Largest Sum.
Memory Usage: 39.1 MB, less than 42.86% of Java online submissions for Find Subsequence of Length K With the Largest Sum.
*/
