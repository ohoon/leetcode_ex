/*
2023.
Number of Pairs of Strings With Concatenation Equal to Target
https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/
*/

class Solution {
    public int numOfPairs(String[] nums, String target) {
        int answer = 0, n = target.length();
        int[] prefix = new int[n+1];
        int[] suffix = new int[n+1];
        for (String num : nums) {
            int m = num.length();
            if (target.startsWith(num)) {       // target이 num으로 시작하면 나머지 부분인 문자의 개수를 suffix 배열에서 찾아서 answer에 더해줌
                answer += suffix[n-m];
            }
            
            if (target.endsWith(num)) {         // target이 num으로 끝나면 나머지 부분인 문자의 개수를 prefix 배열에서 찾아서 answer에 더해줌
                answer += prefix[n-m];
            }
            
            if (target.startsWith(num)) {       // target이 num으로 시작하면 prefix 배열에 num 등록
                prefix[m]++;
            }
            
            if (target.endsWith(num)) {         // target이 num으로 끝나면 suffix 배열에 num 등록
                suffix[m]++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 2 ms, faster than 100.00% of Java online submissions for Number of Pairs of Strings With Concatenation Equal to Target.
Memory Usage: 42.9 MB, less than 28.08% of Java online submissions for Number of Pairs of Strings With Concatenation Equal to Target.
*/
