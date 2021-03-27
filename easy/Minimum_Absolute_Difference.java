/*
1200.
Minimum Absolute Difference
https://leetcode.com/problems/minimum-absolute-difference/
*/

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> answer = new ArrayList<>();
        int min = Integer.MAX_VALUE;    // 최소 diff
        Arrays.sort(arr);               // 오름차순 정렬
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i+1] - arr[i];
            if (diff < min) {           // min보다 작은 diff가 나오면 min 갱신하고 answer 초기화
                min = diff;
                answer.clear();
            }
            
            if (diff == min) {          // diff가 최솟값인 조합을 answer에 추가
                answer.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        
        return answer;
    }
}

/*
Runtime: 14 ms, faster than 97.88% of Java online submissions for Minimum Absolute Difference.
Memory Usage: 49.6 MB, less than 87.31% of Java online submissions for Minimum Absolute Difference.
*/

/*
여담

처음엔 해시맵으로 모든 diff을 저장하다가 시간 초과가 떠서 힌트를 보고 인접한 요소들의 diff만 다루면 된다는 것을 깨달음
다음에 다시 힌트없이 

*/
