/*
373.
Find K Pairs with Smallest Sums
https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
*/

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (x[0]+x[1])-(y[0]+y[1]));       // 배열의 합을 기준으로 오름차순 정렬하는 우선순위 큐
        for (int n1 : nums1) {      // 우선 nums1의 모든 요소와 nums2의 첫 번째 요소와 조합하여 우선순위 큐에 삽입
            pq.offer(new int[]{n1, nums2[0], 0});       // 배열의 3번째 요소는 nums2의 몇 번째 요소를 가지고 조합했는지 알려주는 인덱스 역할을 함
        }
        
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) {
                break;
            }
            
            int[] polled = pq.poll();
            answer.add(Arrays.asList(polled[0], polled[1]));        // 가져온 배열을 answer에 삽입
            if (polled[2] < nums2.length - 1) {     // 다음 nums2 요소를 현재 nums1 요소와 조합하여 우선순위 큐에 제공 (lazy한 offer을 통해서 최적화된 로직이 가능)
                pq.offer(new int[]{polled[0], nums2[polled[2]+1], polled[2]+1});
            }
        }
        
        return answer;
    }
}

/*
Runtime: 50 ms, faster than 39.60% of Java online submissions for Find K Pairs with Smallest Sums.
Memory Usage: 129.6 MB, less than 6.18% of Java online submissions for Find K Pairs with Smallest Sums.
*/

/*
여담

처음에는 우선순위 큐에 nums1와 nums2의 모든 조합 배열을 삽입해서 해결을 하려고 했지만
nums1와 nums2의 최대 크기가 10^5에 달하다보니 시간복잡도 면에서도 그렇고 공간복잡도 적으로도 문제가 컸다.
이 문제를 어떻게 해결할까 고민하다 어떤 사람의 풀이를 보니 이런식으로 lazy하게 해결할 수 있음을 깨달았다.
우선순위 큐의 이점을 제대로 활용한 풀이가 아닐까 싶을 정도로 신선하고 좋았다.

*/
