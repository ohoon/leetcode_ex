/*
1299.
Replace Elements with Greatest Element on Right Side
https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
*/

class Solution {
    public int[] replaceElements(int[] arr) {
        int[] answer = new int[arr.length];
        answer[arr.length-1] = -1;      // 마지막 요소는 -1
        
        int max = 0;                    // 현재까지의 최댓값
        for (int i = arr.length - 1; i > 0; i--) {      // 뒤에서부터 탐색
            if (arr[i] > max) {         // 최댓값 갱신
                max = arr[i];
            }
            
            answer[i-1] = max;          // 현재까지의 최댓값을 대입
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 99.89% of Java online submissions for Replace Elements with Greatest Element on Right Side.
Memory Usage: 39.7 MB, less than 98.74% of Java online submissions for Replace Elements with Greatest Element on Right Side.
*/
