/*
769.
Max Chunks To Make Sorted
https://leetcode.com/problems/max-chunks-to-make-sorted/
*/

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        boolean[] between = new boolean[n-1];       // 각 요소끼리 chunk 연결관계가 있는지 확인하는 불린 배열
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(i, arr[i]); j < Math.max(i, arr[i]); j++) {       // 각 요소별로 현재 인덱스부터 sorting 후의 인덱스까지 chunk로 묶음
                between[j] = true;
            }
        }
        
        int answer = n;
        for (boolean btw : between) {       // chunk는 하나의 요소로 치므로 3개의 요소가 뭉친 chunk는 1개로 취급 (3-2)
            if (btw) {
                answer--;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Max Chunks To Make Sorted.
Memory Usage: 36 MB, less than 89.57% of Java online submissions for Max Chunks To Make Sorted.
*/
