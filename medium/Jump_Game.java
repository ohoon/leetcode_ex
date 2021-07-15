/*
55.
Jump Game
https://leetcode.com/problems/jump-game/
*/

class Solution {
    public boolean canJump(int[] nums) {
        return jump(nums, 0, new HashSet<Integer>());
    }
    
    private boolean jump(int[] arr, int cur, Set set) {
        if (cur >= arr.length - 1) {
            return true;
        }
        
        set.add(cur);
        for (int i = arr[cur]; i > 0; i--) {
            if (!set.contains(cur + i) && jump(arr, cur + i, set)) {
                return true;
            }
        }
        
        return false;
    }
}

/*
Runtime: 684 ms, faster than 8.47% of Java online submissions for Jump Game.
Memory Usage: 43.1 MB, less than 20.76% of Java online submissions for Jump Game.
*/

/*
다른 사람의 풀이

class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        
        //last index from where we can reach to end cell
        //As from last index (n - 1) itself reach to  end cell,  
        int lastIndex = n - 1;
        
        for(int i = n - 1; i >= 0; i--){
            if(i + nums[i] >= lastIndex){
                lastIndex = i;
            }
        }
        
        //check from 0 reach to end cell
        return lastIndex == 0;
    }
}

또는

public boolean canJump(int[] nums) {
    int reachable = 0;
    for (int i=0; i<nums.length; ++i) {
        if (i > reachable) return false;
        reachable = Math.max(reachable, i + nums[i]);
    }
    return true;
}

첫번째 풀이는 뒤부터 시작해서 각 인덱스와 인덱스가 가리키는 값을 더한 것이 lastIndex 이상이면
lastIndex를 해당 인덱스로 갱신하면서 N만큼 반복하는 풀이이다.
각 인덱스가 가리키는 값만큼 for문을 돌릴 필요 없이 lastIndex만 신경쓰면 되므로
시간복잡도가 훨씬 효율적이다..

두번째 풀이 역시 greedy한 풀이로, 앞에서부터 시작하여 닿을 수 있는 거리인 reachable를 갱신하면서
해당 인덱스에 닿을 수 없게 되면 false를 반환하도록 한다.

*/
