/*
1175.
Prime Arrangements
https://leetcode.com/problems/prime-arrangements/
*/

class Solution {
    static int MOD = (int) (1e9 + 7);
    
    public int numPrimeArrangements(int n) {
        HashSet<Integer> primes = new HashSet<>();      // set
        for (int i = 2; i <= n; i++) {
            primes.add(i);
        }
        
        for (int i = 2; i <= n; i++) {                  // 에라토스테네스의 체
            if (primes.contains(i)){
                for (int j = 2 * i; j <= n; j += i) {
                    primes.remove(j);
                }
            }
        }
        
        long answer = 1L;
        int p = primes.size();                          // prime 개수
        for (int i = 2; i <= p; i++)                    // 소수와 합성수 별로 팩토리얼 연산을 하여 answer에 추가
            answer = (answer * i) % MOD;
        
        for (int i = 2; i <= n - p; i++)
            answer = (answer * i) % MOD;
        
        return (int) answer;
    }
}

/*
Runtime: 1 ms, faster than 31.14% of Java online submissions for Prime Arrangements.
Memory Usage: 36.1 MB, less than 32.34% of Java online submissions for Prime Arrangements.
*/

/*
여담

문제 풀이 자체는 에라토스테네스의 체를 이용한 소수 개수 찾기로 익숙한 문제였지만 overflow 문제를 해결하는 것이 제일 힘들었다.
팩토리얼을 하면서 발생하는 오버플로우로 값이 자꾸 마이너스가 되서 제대로 된 결과값이 나오지 않았는데,
long타입을 사용하여 해결이 가능했다. 하지만 팩토리얼 연산을 함수로 만들어서 재귀적으로 풀면 오버플로우 예외가 발생하기 때문에 반복법을 사용해야함

*/
