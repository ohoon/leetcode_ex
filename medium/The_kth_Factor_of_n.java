/*
1492.
The kth Factor of n
https://leetcode.com/problems/the-kth-factor-of-n/
*/

class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {     // 1부터 n의 제곱근까지 탐색하여 인수를 factors에 삽입
            if (n % i == 0) {
                factors.add(i);
                if (i * i != n) {       // i가 제곱근인 경우에는 한번만 삽입됨
                    factors.add(n / i);
                }
            }
        }
        
        Collections.sort(factors);      // 오름차순 정렬
        if (factors.size() < k) {
            return -1;
        }
        
        return factors.get(k-1);
    }
}

/*
Runtime: 1 ms, faster than 70.89% of Java online submissions for The kth Factor of n.
Memory Usage: 35.8 MB, less than 69.81% of Java online submissions for The kth Factor of n.
*/
