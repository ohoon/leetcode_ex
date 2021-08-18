/*
238.
Product of Array Except Self
https://leetcode.com/problems/product-of-array-except-self/
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;          // 모든 요소의 곱 (0 제외)
        int zeroIndex = -1;     // 0인 요소의 인덱스
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {                 // 0인 요소 발견
                if (zeroIndex > -1) {           // 0인 요소가 2개 이상 나오면 모든 요소가 0인 배열 반환
                    return new int[nums.length];
                }
                
                zeroIndex = i;
                continue;
            }
            
            total *= nums[i];                   // 0이 아닌 요소는 total에 곱함
        }
        
        int[] answer = new int[nums.length];
        if (zeroIndex > -1) {                   // 0인 요소가 존재하면 해당 인덱스만 total 대입하여 반환
            answer[zeroIndex] = total;
            return answer;
        }
        
        for (int i = 0; i < nums.length; i++) {     // 0인 요소가 존재하지 않으면 각각의 요소별로 total에서 자기 자신을 제외한 값을 answer에 대입
            answer[i] = total / nums[i];
        }

        return answer;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
Memory Usage: 50 MB, less than 42.87% of Java online submissions for Product of Array Except Self.
*/
