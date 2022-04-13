/*
870.
Advantage Shuffle
https://leetcode.com/problems/advantage-shuffle/
*/

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        Integer[] index2 = new Integer[nums2.length];       // nums2의 인덱스를 나타내는 배열
        for (int i = 0; i < nums2.length; i++) {
            index2[i] = i;
        }
        
        Arrays.sort(nums1);     // 오름차순 정렬
        Arrays.sort(index2, (i, j) -> Integer.compare(nums2[i], nums2[j]));     // 인덱스 배열을 정렬하여 간접적으로 nums2를 오름차순 정렬
        Deque<Integer> deq = new LinkedList<>();        // nums1에서 사용되지 않은 요소들을 담을 deque
        int cur = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] <= nums2[index2[cur]]) {       // 조건이 성립하지 않으면 덱에 넣어두고 나중에 pop해서 사용
                deq.push(nums1[i]);
                continue;
            }
            
            answer[index2[cur++]] = nums1[i];           // 조건이 성립하면 nums[i]를 해당 인덱스에 맞는 자리에 맞게 삽입
        }
        
        while (cur < index2.length) {                   // 조건에 맞지 않아 사용되지 못한 요소들을 차례대로 삽입
            answer[index2[cur++]] = deq.pop();
        }
        
        return answer;
    }
}

/*
Runtime: 74 ms, faster than 87.75% of Java online submissions for Advantage Shuffle.
Memory Usage: 57.2 MB, less than 99.34% of Java online submissions for Advantage Shuffle.
*/
