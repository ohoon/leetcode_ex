/*
1619.
Mean of Array After Removing Some Elements
https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
*/

class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);       // 오름차순 정렬
        double total = 0.0;
        int count = arr.length / 20;
        for (int i = count; i < arr.length - count; i++) {      // 앞, 뒤에서 5%를 제외한 수들의 합을 계산
            total += arr[i];
        }

        return total / (arr.length - count * 2);        // 평균 반환
    }
}

/*
Runtime: 2 ms, faster than 97.83% of Java online submissions for Mean of Array After Removing Some Elements.
Memory Usage: 39.3 MB, less than 12.17% of Java online submissions for Mean of Array After Removing Some Elements.
*/
