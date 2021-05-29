/*
1805.
Number of Different Integers in a String
https://leetcode.com/problems/number-of-different-integers-in-a-string/
*/

import java.math.BigInteger;

class Solution {
    public int numDifferentIntegers(String word) {
        StringBuilder sb = new StringBuilder();
        for (char w : word.toCharArray()) {
            if (w < 48 || w > 57) {
                sb.append(' ');
            } else {
                sb.append(w);
            }
        }
        
        Set<BigInteger> set = Arrays.stream(sb.toString().split(" "))
            .filter(s -> !s.isEmpty()).map(s -> new BigInteger(s)).collect(Collectors.toSet());
        return set.size();
    }
}

/*
Runtime: 6 ms, faster than 43.05% of Java online submissions for Number of Different Integers in a String.
Memory Usage: 39.3 MB, less than 14.71% of Java online submissions for Number of Different Integers in a String.
*/

/*
다른 사람의 풀이

class Solution {
    public int numDifferentIntegers(String word) {
        String[] arr = word.replaceAll("[a-zA-Z]", " ").split("\\s+");
        Set<String> set = new HashSet<String>();
            
        for (String str : arr) {
            if (!str.isEmpty())
                set.add(String.valueOf(str.replaceAll("^0*","")));
        }
                
        return set.size();
    }
}

BigInteger이 아닌 정규식으로 풀이한 코드이다.
정규식에 익숙하면 쉽게 풀이할 수 있는 문제지만 정규식 특성상 수많은 기호들을 외워야하고 찾아써야한다는 점이 마음에 들지 않아 사용하지 않았다.
math 모듈에서 제공하는 Big Integer은 일반 integer의 overflow를 방지하는 좀더 범위가 큰 개념의 integer이다.

*/
