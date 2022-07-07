/*
1814.
Count Nice Pairs in an Array
https://leetcode.com/problems/count-nice-pairs-in-an-array/
*/

class Solution {
    private long rev(int num) {         // num을 뒤집은 숫자를 반환하는 메서드
        int n = num;
        long res = 0;
        while (n > 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }
        
        return res;
    }
    
    public int countNicePairs(int[] nums) {
        long answer = 0;
        int modulo = 1000000007;
        Map<Long, Integer> countMap = new HashMap<>();      // n과 rev(n)의 차이를 key로 하는 카운팅용 맵
        for (int n : nums) {
            long diff = n - rev(n);
            if (countMap.containsKey(diff)) {               // diff가 같은 쌍만이 nice pair가 될 수 있음
                answer = (answer + countMap.get(diff)) % modulo;
            }
            
            countMap.put(diff, countMap.getOrDefault(diff, 0) + 1);
        }
        
        return (int) answer;
    }
}

/*
Runtime: 104 ms, faster than 20.59% of Java online submissions for Count Nice Pairs in an Array.
Memory Usage: 84 MB, less than 18.33% of Java online submissions for Count Nice Pairs in an Array.
*/
