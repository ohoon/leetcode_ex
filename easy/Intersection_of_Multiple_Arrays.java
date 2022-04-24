/*
2248.
Intersection of Multiple Arrays
https://leetcode.com/problems/intersection-of-multiple-arrays/
*/

class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] arr = new int[1001];
        for (int[] num : nums) {        // nums의 숫자들의 빈도수를 측정
            for (int n : num) {
                arr[n]++;
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            if (arr[i] == nums.length) {        // 숫자의 빈도수가 배열들 개수와 같으면 모든 배열에 존재하는 숫자이므로 answer에 삽입
                answer.add(i);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 100.00% of Java online submissions for Intersection of Multiple Arrays.
Memory Usage: 46.2 MB, less than 100.00% of Java online submissions for Intersection of Multiple Arrays.
*/
