/*
970.
Powerful Integers
https://leetcode.com/problems/powerful-integers/
*/

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> answer = new HashSet<>();      // 중복 제거를 위해 hashset 사용
        int a = x == 1 ? 0 : (int) (Math.log(bound) / Math.log(x));     // x^a <= bound되도록 범위 조절
        int b = y == 1 ? 0 : (int) (Math.log(bound) / Math.log(y));
        for (int i = 0; i <= a; i++) {
            int xx = (int) Math.pow(x, i);
            for (int j = 0; j <= b; j++) {
                int yy = (int) Math.pow(y, j);
                if (xx + yy > bound) {
                    break;
                }
                
                if (xx + yy <= bound) {
                    answer.add(xx+yy);
                }
            }
        }
        
        return new ArrayList<>(answer);
    }
}

/*
Runtime: 2 ms, faster than 70.56% of Java online submissions for Powerful Integers.
Memory Usage: 42.3 MB, less than 13.89% of Java online submissions for Powerful Integers.
*/
