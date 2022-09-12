/*
2404.
Most Frequent Even Element
https://leetcode.com/problems/most-frequent-even-element/
*/

class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();        // 키 값을 오름차순으로 map에 저장하기 위해 treemap 사용
        for (int n : nums) {
            if (n % 2 == 1) {
                continue;
            }
            
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int answer = -1, max = 0;
        for (int n : map.keySet()) {
            if (map.get(n) > max) {
                answer = n;
                max = map.get(n);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 85 ms, faster than 18.18% of Java online submissions for Most Frequent Even Element.
Memory Usage: 59 MB, less than 9.09% of Java online submissions for Most Frequent Even Element.
*/
