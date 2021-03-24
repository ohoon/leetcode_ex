/*
1137.
N-th Tribonacci Number
https://leetcode.com/problems/n-th-tribonacci-number/
*/

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();            # memorize, 해시 테이블
    
    public int tribonacci(int n) {
        if (map.containsKey(n)) {           # 해당 트리보나치 값이 해시 테이블에 있으면 바로 반환
            return map.get(n);
        }
        
        if (n == 0) {
            return 0;
        }
        
        if (n == 1 || n == 2) {
            return 1;
        }
        
        int result = tribonacci(n-3) + tribonacci(n-2) + tribonacci(n-1);           # 재귀법
        map.put(n, result);                 # 트리보나치 결과를 해시 테이블에 등록
        
        return result;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for N-th Tribonacci Number.
Memory Usage: 35.7 MB, less than 57.07% of Java online submissions for N-th Tribonacci Number.
*/
