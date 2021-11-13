/*
1833.
Maximum Ice Cream Bars
https://leetcode.com/problems/maximum-ice-cream-bars/
*/

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);         // greedy하게 접근
        for (int i = 0; i < costs.length; i++) {
            coins -= costs[i];
            if (coins < 0) {        // 코인을 다 쓰면 현재까지 결제한 횟수 반환하고 종료
                return i;
            }
        }
        
        return costs.length;
    }
}

/*
Runtime: 31 ms, faster than 96.34% of Java online submissions for Maximum Ice Cream Bars.
Memory Usage: 56.3 MB, less than 39.94% of Java online submissions for Maximum Ice Cream Bars.
*/
