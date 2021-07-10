/*
18.
4Sum
https://leetcode.com/problems/4sum/
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);          // L, R 2개의 포인터를 가지고 증감하여 target을 맞추기 위함
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int L = j + 1, R = nums.length - 1;
                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target) {            // 네 원소의 합이 target과 동일하면 set에 추가하고 L 증가
                        set.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[L], nums[R])));
                        L++;
                    } else if (sum > target) {      // target보다 크면 R 감소
                        R--;
                    } else {                        // target보다 작으면 L 증가
                        L++;
                    }
                }
            }
        }
        
        return new ArrayList<>(set);
    }
}

/*
Runtime: 35 ms, faster than 20.09% of Java online submissions for 4Sum.
Memory Usage: 41.8 MB, less than 8.99% of Java online submissions for 4Sum.
*/
