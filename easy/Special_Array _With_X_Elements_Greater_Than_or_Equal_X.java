/*
1608.
Special Array With X Elements Greater Than or Equal X
https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
*/

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int current = 1;
        for (int i = 0; i < length; i++) {
            while (current <= nums[i]) {
                if (current == length - i) {
                    return current;
                }
                
                current++;
            }
        }
        
        return -1;
    }
}

/*
Runtime: 1 ms, faster than 76.13% of Java online submissions for Special Array With X Elements Greater Than or Equal X.
Memory Usage: 36.3 MB, less than 89.98% of Java online submissions for Special Array With X Elements Greater Than or Equal X.
*/

/*
다른 사람의 풀이

class Solution {
    public int specialArray(int[] nums) {
        int x = nums.length;
        int[] counts = new int[x+1];
        
        for(int elem : nums)
            if(elem >= x)
                counts[x]++;
            else
                counts[elem]++;
        
        int res = 0;
        for(int i = counts.length-1; i > 0; i--) {
            res += counts[i];
            if(res == i)
                return i;
        }
        
        return -1;
    }
}

정렬을 사용하지 않고 정적 배열에 counting을 하여
나중에 count 배열 안의 수를 이용해서 개수를 추측하여 풀이하는 방법이다.
확실히 정렬 안쓰고 O(N)에 풀이할 수 있어 강점인듯하다.

*/
