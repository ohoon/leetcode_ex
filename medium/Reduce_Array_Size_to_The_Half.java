/*
1338.
Reduce Array Size to The Half
https://leetcode.com/problems/reduce-array-size-to-the-half/
*/

class Solution {
    public int minSetSize(int[] arr) {
        int answer = 0;
        int n = arr.length;     // arr의 전체 길이 
        int remained = arr.length;      // 요소들을 제거하고 남은 길이
        Map<Integer, Integer> map = new HashMap<>();        // 요소의 개수를 카운팅하는 용도인 hashmap
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Integer[] distinct = map.keySet().toArray(Integer[]::new);      // 중복된 요소를 제거한 배열
        Arrays.sort(distinct, (x, y) -> Integer.compare(map.get(y), map.get(x)));   // 요소의 개수를 기준으로 내림차순 정렬
        for (Integer num : distinct) {      // 개수가 많은 것부터 제거해나감
            remained -= map.get(num);
            answer++;
            if (remained <= n/2) {          // 절반 이상을 제거하면 for문을 탈출하고 결과값을 반환
                break;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 87 ms, faster than 43.81% of Java online submissions for Reduce Array Size to The Half.
Memory Usage: 83.7 MB, less than 65.56% of Java online submissions for Reduce Array Size to The Half.
*/
