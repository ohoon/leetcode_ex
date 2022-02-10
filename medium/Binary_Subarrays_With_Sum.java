/*
930.
Binary Subarrays With Sum
https://leetcode.com/problems/binary-subarrays-with-sum/
*/

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums, goal) - atmost(nums, goal-1);       // (합이 goal 이하인 부분집합의 개수) - (합이 goal - 1 이하인 부분집합의 개수) = (합이 goal인 부분 집합의 개수)
    }
    
    private int atmost(int[] nums, int goal) {
        int l = 0 , r = 0 , count = 0, result = 0;
        while (r < nums.length) {
           count += nums[r];
           while (l <= r && count > goal) {     // count == goal이 될 때까지 l 포인터를 늘려줌
               count -= nums[l];
               l++;
           }
            
           result += r - l + 1;     // 추가된 부분집합의 개수는 l 포인터와 r 포인터 사이의 요소 개수와 같음
           r++;
        }
        
        return result;
    }
}

/*
Runtime: 3 ms, faster than 78.16% of Java online submissions for Binary Subarrays With Sum.
Memory Usage: 53.7 MB, less than 41.13% of Java online submissions for Binary Subarrays With Sum.
*/

/*
여담

무식하게 O(N^2) 방법으로 풀다보니 시간 초과가 되서 다른 방법을 생각했어야 했음
1시간정도 고민하다가 도무지 좋은 방법이 안떠올라서 솔루션과 다른 사람 풀이를 참고해서 풀었음
솔루션이나 위의 풀이나 이해하는 것도 무척 어려웠다...
문제가 간단한거에 비해서 좋은 코드를 짜기 위해서는 굉장히 머리가 아픈 문제였다.

*/
