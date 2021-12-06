/*
1283.
Find the Smallest Divisor Given a Threshold
https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
*/

class Solution {
    private int getSumOfDivision(int[] nums, int divisor) {     // nums를 divisor로 나눈 몫의 합을 반환하는 함수
        int result = 0;
        for (int n : nums) {
            result += n / divisor;
        }

        return result;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int L = 1, R = Arrays.stream(nums).max().getAsInt();
        threshold -= nums.length;   // 전체적으로 올림이기 때문에 미리 1씩 빼줌
        if (threshold == 0) {       // 1+1+...+1인 경우
            return R;
        }

        for (int i = 0; i < nums.length; i++) {     // 전체적으로 올림이기 때문에 1을 미리 빼줌
            nums[i]--;
        }

        while (L < R) {             // 이진 탐색
            int M = (L + R) / 2;
            if (getSumOfDivision(nums, M) > threshold) {
                L = M + 1;
            } else {
                R = M;
            }
        }

        return L;
    }
}

/*
Runtime: 10 ms, faster than 80.49% of Java online submissions for Find the Smallest Divisor Given a Threshold.
Memory Usage: 43.3 MB, less than 66.77% of Java online submissions for Find the Smallest Divisor Given a Threshold.
*/
