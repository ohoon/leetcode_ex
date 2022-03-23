/*
838.
Push Dominoes
https://leetcode.com/problems/push-dominoes/
*/

class Solution {
    private TreeMap<Integer, Character> map;
    
    private int getLowerLength(int current) {       // 현재 인덱스와 그보다 작은 인덱스와의 거리를 반환하는 메서드
        try {
            int i = map.lowerKey(current);
            if (map.get(i) == 'L') {                // 왼쪽으로 넘어지는 도미노는 현재 인덱스에 영향을 주지 않음
                return Integer.MAX_VALUE;
            }
            
            return current - i;
        } catch (NullPointerException err) {        // 가까운 인덱스가 없으면 null pointer 예외가 발생됨
            return Integer.MAX_VALUE;
        }
    }   
    
    private int getHigherLength(int current) {      // 현재 인덱스와 그보다 큰 인덱스와의 거리를 반환하는 메서드
        try {
            int i = map.higherKey(current);
            if (map.get(i) == 'R') {                // 오른쪽으로 넘어지는 도미노는 현재 인덱스에 영향을 주지 않음
                return Integer.MAX_VALUE;
            }
            
            return i - current;
        } catch (NullPointerException err) {
            return Integer.MAX_VALUE;
        }
    }
        
    public String pushDominoes(String dominoes) {
        map = new TreeMap<>();
        for (int i = 0; i < dominoes.length(); i++) {       // L와 R 도미노의 위치를 key로 하여 map에 삽입
            char d = dominoes.charAt(i);
            if (d == '.') {
                continue;
            }
            
            map.put(i, d);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dominoes.length(); i++) {
            char d = dominoes.charAt(i);
            if (d != '.') {
                sb.append(d);
                continue;
            }
            
            int higher = getHigherLength(i);
            int lower = getLowerLength(i);
            if (higher < lower) {       // 오른쪽에서 오는 힘(L)이 더 가까울 경우
                sb.append('L');
                continue;
            }
            
            if (higher > lower) {       // 왼쪽에서 오는 힘(R)이 더 가까울 경우
                sb.append('R');
                continue;
            }
            
            sb.append('.');             // 양 쪽에서 오는 힘이 같으면 . 그대로 삽입
        }
        
        return sb.toString();
    }
}

/*
Runtime: 482 ms, faster than 5.00% of Java online submissions for Push Dominoes.
Memory Usage: 76.3 MB, less than 5.00% of Java online submissions for Push Dominoes.
*/

/*
여담

문제를 읽고 TreeMap에서 제공하는 lower higher메서드를 이용하면 효과적이라 생각했는데,
생각보다 시간초가 많이 나왔다. 문제 풀이를 보니 dp를 사용해서 보다 최적화할 수 있다는 것 같다.

*/
