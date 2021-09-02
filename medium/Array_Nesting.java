/*
565.
Array Nesting
https://leetcode.com/problems/array-nesting/
*/

class Solution {
    public int arrayNesting(int[] nums) {
        int answer = 0;
        boolean[] used = new boolean[nums.length];          // 이미 앞에서 사용된 숫자 표시용
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {      // 이미 사용된 i이므로 i부터 nesting을 시작해도 앞에서 계산한 nesting의 하위 집합에 해당
                continue;
            }
            
            int count = 0, cur = i;
            do {
                used[cur] = true;
                cur = nums[cur];        // nesting하기 위해 cur 갱신
                count++;
            } while (!used[cur]);       // cycle이 발생하면 중단
            
            answer = Math.max(answer, count);
        } 
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 40.75% of Java online submissions for Array Nesting.
Memory Usage: 45.7 MB, less than 13.27% of Java online submissions for Array Nesting.
*/
