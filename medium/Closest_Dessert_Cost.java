/*
1774.
Closest Dessert Cost
https://leetcode.com/problems/closest-dessert-cost/
*/

class Solution {
    /** Closest cost result */
    int closestCost = Integer.MAX_VALUE;
    /** Difference between closest cost result and target so far */
    int closestCostDiff = Integer.MAX_VALUE;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int base : baseCosts) {
            dfs(toppingCosts, 0, base, target);
        }
        return closestCost;
    }

    public void dfs(int[] toppingCosts, int toppingIndex, int cost, int target) {
        int costDiff = Math.abs(target - cost);
        if (costDiff < closestCostDiff || (costDiff == closestCostDiff && cost < closestCost)) {
            closestCostDiff = costDiff;
            closestCost = cost;
        }
        
        // Since toppings are all positive cost, stop dfs early if cost exceeds target
        if (toppingIndex >= toppingCosts.length || cost > target)
            return;

        dfs(toppingCosts, toppingIndex + 1, cost, target);
        dfs(toppingCosts, toppingIndex + 1, cost + toppingCosts[toppingIndex], target);
        dfs(toppingCosts, toppingIndex + 1, cost + 2 * toppingCosts[toppingIndex], target);
    }
}

/*
Runtime: 5 ms, faster than 66.26% of Java online submissions for Closest Dessert Cost.
Memory Usage: 38.6 MB, less than 20.86% of Java online submissions for Closest Dessert Cost.
*/

/*
나의 풀이

class Solution {
    private int topping(int[] toppingCosts, int[] toppingCounts, int target) {
        int result = target;
        int m = toppingCosts.length;
        for (int i = 0; i < m; i++) {
            if (toppingCounts[i] >= 2) {
                continue;
            }
            
            toppingCounts[i]++;
            int next = topping(toppingCosts, toppingCounts, target - toppingCosts[i]);
            if (Math.abs(next) < Math.abs(result)) {
                result = next;
            } else if (Math.abs(next) == Math.abs(result)) {
                result = Math.max(next, result);
            }
            
            toppingCounts[i]--;
        }
        
        return result;
    }
    
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int answer = Integer.MAX_VALUE;
        int n = baseCosts.length, m = toppingCosts.length;
        for (int i = 0; i < n; i++) {
            int result = topping(toppingCosts, new int[m], target - baseCosts[i]);
            if (Math.abs(result) < Math.abs(answer)) {
                answer = result;
            }
        }
        
        return target - answer;
    }
}

백트래킹을 이용해서 재귀적으로 푸는 문제라는 것은 감을 잡았는데,
실제로 구현을 해보면서 굉장히 머리가 아팠다.
이리저리 재귀 함수를 짜보면서 많이 시도해봤는데 하나씩 예외 테스트케이스에 걸려서 골치가 아팠음
나처럼 괜히 머리아프게 toppingCount 배열을 하나 만들어서 2회 초과해서 토핑을 못올리도록 할 것이 아니라
그냥 아예 재귀식을 부를 때 토핑을 0회, 1회, 2회 올릴 경우의 수에 맞춰 부르면 엄청 간단해지는 거였다...
정답 풀이를 보니 허무하기도 하고 왜이리 복잡하게 생각했나 착잡한 심정이다.
*/
