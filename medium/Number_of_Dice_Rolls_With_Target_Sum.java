/*
1155.
Number of Dice Rolls With Target Sum
https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
*/

class Solution {
    private Map<String, Integer> map = new HashMap<>();     // for memoization
    
    public int numRollsToTarget(int n, int k, int target) {
        if (n*k < target) {     // 주사위 값을 너무 적게 가져갔을 경우
            return 0;
        }
        
        if (n == 1) {       // 재귀 종료 부분
            return 1;
        }
        
        String key = "" + n + k + target;       // map의 key로 현재 n, k, target값을 문자열로 치환하여 사용
        if (map.containsKey(key)) {         // 이미 계산된 값이라면 map에 있는 것을 사용
            return map.get(key);
        }
        
        int res = 0;
        for (int i = 1; i <= Math.min(k, target-n+1); i++) {        // 주사위 값을 너무 크게 가져가지 않도록 target-n+1로 제한을 둠
            res += numRollsToTarget(n-1, k, target-i);          // 주사위 하나를 굴린 후, 다음 주사위를 구르기 위해 재귀
            res %= 1000000007;
        }
        
        map.put(key, res);
        return res;
    }
}

/*
Runtime: 100 ms, faster than 17.15% of Java online submissions for Number of Dice Rolls With Target Sum.
Memory Usage: 54.2 MB, less than 11.79% of Java online submissions for Number of Dice Rolls With Target Sum.
*/
