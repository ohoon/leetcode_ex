/*
1589.
Maximum Sum Obtained of Any Permutation
https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/
*/

class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        Arrays.sort(nums);
        double answer = 0;
        int[] freq = new int[nums.length+1];        // request에 해당하는 인덱스 빈도값을 나타내는 배열
        double limit = Math.pow(10, 9) + 7;         // overflow 방지용 변수
        for (int i = 0; i < requests.length; i++) { // request의 시작과 끝 인덱스만 체크
            freq[requests[i][0]]++;
            freq[requests[i][1]+1]--;
        }
        
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i-1];
        }
        
        Arrays.sort(freq);
        for (int i = nums.length - 1; i >= 0; i--) {    // greedy하게 가장 큰 값을 가장 많이 사용하도록 풀이함
            if (freq[i+1] == 0) {
                break;
            }
            
            answer += (double) nums[i] * freq[i+1];
            if (answer >= limit) {
                answer %= limit;
            }
        }
        
        return (int) answer;
    }
}

/*
Runtime: 18 ms, faster than 92.04% of Java online submissions for Maximum Sum Obtained of Any Permutation.
Memory Usage: 75.3 MB, less than 54.87% of Java online submissions for Maximum Sum Obtained of Any Permutation.
*/
