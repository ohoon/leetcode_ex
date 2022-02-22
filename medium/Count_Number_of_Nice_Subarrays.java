/*
1248.
Count Number of Nice Subarrays
https://leetcode.com/problems/count-number-of-nice-subarrays/
*/

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int answer = 0;
        int n = nums.length;
        List<Integer> oddList = new ArrayList<>();      // 홀수 요소의 인덱스를 저장하는 리스트
        oddList.add(-1);        // 배열의 시작 위치 추가
        for (int i = 0; i < n; i++) {       // 홀수인 것만 인덱스를 리스트에 저장
            if (nums[i] % 2 == 1) {
                oddList.add(i);
            }
        }
        
        oddList.add(n);         // 배열의 끝 위치 추가
        for (int i = 1; i < oddList.size() - k; i++) {
            int left = oddList.get(i) - oddList.get(i-1);       // (i-1)--left--(i)---------k개----------(i+k-1)--right--(i+k) 인 상황에서 subarray의 경우의수는 left * right
            int right = oddList.get(i+k) - oddList.get(i+k-1);
            answer += left * right;
        }
        
        return answer;
    }
}

/*
Runtime: 26 ms, faster than 37.00% of Java online submissions for Count Number of Nice Subarrays.
Memory Usage: 75.9 MB, less than 51.44% of Java online submissions for Count Number of Nice Subarrays.
*/
