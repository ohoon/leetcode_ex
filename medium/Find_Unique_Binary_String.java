/*
1980.
Find Unique Binary String
https://leetcode.com/problems/find-unique-binary-string/
*/

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        int n = nums.length;
        for (int i = 0; i < n; i++) {       // greedy
            char bit = nums[i].charAt(i);
            sb.append(bit == '0' ? '1' : '0');      // 각 binary string들에서 위치가 겹치지 않는 하나의 비트씩만 같지 않게 만들면 됨
        }
        
        return sb.toString();
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Unique Binary String.
Memory Usage: 42.5 MB, less than 41.68% of Java online submissions for Find Unique Binary String.
*/
