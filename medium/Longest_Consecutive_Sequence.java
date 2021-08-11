/*
128.
Longest Consecutive Sequence
https://leetcode.com/problems/longest-consecutive-sequence/
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        for (int num : nums) {          // 모든 숫자 hashset에 저장
            set.add(num);
        }

        for (int num : set) {
            if (set.contains(num - 1)) {        // sequence 시작 숫자만
                continue;
            }

            int count = 1, curr = num;
            while (set.contains(curr + 1)) {    // 불연속적이게 될 때까지 count 증가
                count++;
                curr++;
            }

            answer = Math.max(answer, count);   // answer 갱신
        }

        return answer;
    }
}

/*
Runtime: 14 ms, faster than 70.28% of Java online submissions for Longest Consecutive Sequence.
Memory Usage: 54.4 MB, less than 30.29% of Java online submissions for Longest Consecutive Sequence.
*/
