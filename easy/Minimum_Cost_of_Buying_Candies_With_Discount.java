/*
2144.
Minimum Cost of Buying Candies With Discount
https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/
*/

class Solution {
    public int minimumCost(int[] cost) {
        int answer = Arrays.stream(cost).sum();     // 전체 요소의 합
        Arrays.sort(cost);      // 오름차순 정렬
        for (int i = cost.length - 3; i >= 0; i -= 3) {     // 가장 큰 요소부터 시작해서 3의 배수번째 요소는 free
            answer -= cost[i];
        }
        
        return answer;
    }
}

/*
Runtime: 5 ms, faster than 16.67% of Java online submissions for Minimum Cost of Buying Candies With Discount.
Memory Usage: 39.8 MB, less than 33.33% of Java online submissions for Minimum Cost of Buying Candies With Discount.
*/
