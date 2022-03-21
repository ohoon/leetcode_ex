/*
2210.
Count Hills and Valleys in an Array
https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
*/

class Solution {
    public int countHillValley(int[] nums) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {     // 중복되는 num을 제거하는 작업
            if (nums[i] == nums[i-1]) {
                continue;
            }
            
            list.add(nums[i]);
        }
        
        for (int i = 1; i < list.size() - 1; i++) {
            if ((list.get(i) - list.get(i-1)) * (list.get(i) - list.get(i+1)) < 0) {        // hill이나 valley가 되기 위해서
                continue;                                                                   // list.get(i)가 list.get(i-1)와 list.get(i+1)보다 크거나 작아야함
            }
            
            answer++;
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 33.33% of Java online submissions for Count Hills and Valleys in an Array.
Memory Usage: 42.1 MB, less than 66.67% of Java online submissions for Count Hills and Valleys in an Array.
*/
