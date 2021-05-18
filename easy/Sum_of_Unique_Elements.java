/*
1748.
Sum of Unique Elements
https://leetcode.com/problems/sum-of-unique-elements/
*/

class Solution {
    public int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        int answer = 0;
        for (int num : nums) {
            if (arr[num] == 0) {            // 처음 나온 수라면 answer에 더함
                answer += num;
            } else if (arr[num] == 1) {     // 2번째 나온 수라면 answer에서 첫번째로 나왔던 수 제거
                answer -= num;
            }

            arr[num]++;
        }

        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Unique Elements.
Memory Usage: 36.4 MB, less than 84.59% of Java online submissions for Sum of Unique Elements.
*/
