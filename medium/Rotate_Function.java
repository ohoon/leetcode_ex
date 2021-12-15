/*
396.
Rotate Function
https://leetcode.com/problems/rotate-function/
*/

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();        // 전체 합
        int result = 0;
        for (int i = 0; i < n; i++) {               // nums의 초기 형태에서 인덱스 * 요소값을 적용한 값
            result += i * nums[i];
        }

        int answer = result;
        for (int i = n-1; i >= 0; i--) {            // 오른쪽으로 시프트되면 전체 sum에서 제일 끝 요소 * 3 만큼 빠지게 되고
            result += sum - nums[i] - (n - 1) * nums[i];    // 전체적으로 요소 값이 하나씩 증가되는 성질을 이용한다.
            answer = Math.max(answer, result);
        }

        return answer;
    }
}

/*
Runtime: 20 ms, faster than 5.34% of Java online submissions for Rotate Function.
Memory Usage: 112 MB, less than 16.79% of Java online submissions for Rotate Function.
*/
