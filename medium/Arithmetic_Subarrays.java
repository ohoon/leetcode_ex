/*
1630.
Arithmetic Subarrays
https://leetcode.com/problems/arithmetic-subarrays/
*/

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> answer = new ArrayList<>();
        int n = l.length;
        for (int i = 0; i < n; i++) {
            int max = nums[l[i]];
            int min = nums[l[i]];
            for (int j = l[i]+1; j <= r[i]; j++) {      // 범위에서의 최대값, 최소값
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
            }
            
            if (max == min) {           // 모든 원소가 같은 값일 경우 Arithmetic
                answer.add(true);
                continue;
            }
            
            if ((max - min) % (r[i] - l[i]) != 0) {     // 평균 편차가 정수가 아니면 Arithmetic하지 않음
                answer.add(false);
                continue;
            }
            
            int diffAvg = (max - min) / (r[i] - l[i]);      // 평균 편차
            boolean isArithmetic = true;
            boolean[] dupCheck = new boolean[r[i]-l[i]+1];      // 중복된 값이 들어가는 것을 방지하기 위함
            for (int j = l[i]; j <= r[i]; j++) {
                int index = (nums[j] - min) / diffAvg;          // 정렬되었다고 가정할때 현재 원소가 위치할 인덱스
                if ((nums[j] - min) % diffAvg != 0 || dupCheck[index]) {
                    isArithmetic = false;
                    break;
                }
                
                dupCheck[index] = true;
            }
            
            answer.add(isArithmetic);
        }
        
        return answer;
    }
}

/*
Runtime: 15 ms, faster than 97.83% of Java online submissions for Arithmetic Subarrays.
Memory Usage: 53.7 MB, less than 83.50% of Java online submissions for Arithmetic Subarrays.
*/
