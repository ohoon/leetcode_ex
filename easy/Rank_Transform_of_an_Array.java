/*
1331.
Rank Transform of an Array
https://leetcode.com/problems/rank-transform-of-an-array/
*/

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();    // 각 숫자의 rank를 기록하는 해시맵
        int[] sorted = arr.clone();                         // 정렬용 arr 사본
        int[] answer = new int[arr.length];
        int rank = 1;
        Arrays.sort(sorted);                                // 오름차순 정렬
        
        for (int num : sorted) {                            // 작은 수부터 해시맵에 기록
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }
        
        for (int i = 0; i < arr.length; i++) {              // arr 순서대로 해시맵에서 rank 값을 꺼내어 대입
            answer[i] = map.get(arr[i]);
        }
        
        return answer;
    }
}

/*
Runtime: 25 ms, faster than 56.64% of Java online submissions for Rank Transform of an Array.
Memory Usage: 55.2 MB, less than 54.06% of Java online submissions for Rank Transform of an Array.
*/
