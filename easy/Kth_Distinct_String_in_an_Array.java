/*
2053.
Kth Distinct String in an Array
https://leetcode.com/problems/kth-distinct-string-in-an-array/
*/

class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {          // 각 문자열의 빈도 수를 HashMap에 저장
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for (String s : arr) {
            if (map.get(s) > 1) {       // distinct한 문자열만 처리
                continue;
            }
            
            if (--k == 0) {             // k를 감소, 만약 k가 0이 되면 현재 문자열을 반환
                return s;
            }
        }
        
        return "";
    }
}

/*
Runtime: 4 ms, faster than 70.00% of Java online submissions for Kth Distinct String in an Array.
Memory Usage: 38.9 MB, less than 10.00% of Java online submissions for Kth Distinct String in an Array.
*/
