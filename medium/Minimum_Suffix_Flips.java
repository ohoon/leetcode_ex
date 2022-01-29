/*
1529.
Minimum Suffix Flips
https://leetcode.com/problems/minimum-suffix-flips/
*/

class Solution {
    public int minFlips(String target) {
        int answer = 0;
        char prev = '0';
        for (int i = 0; i < target.length(); i++) {     // target의 앞에서부터 비트가 달라질때마다 flip (11001 -> 11 | 00 | 1)
            char curr = target.charAt(i);
            if (curr == prev) {     // 연속된 비트가 오면 패스
                continue;
            }
            
            answer++;               // flip 회수를 하나 늘리고 prev 갱신
            prev = curr;
        }
        
        return answer;
    }
}

/*
Runtime: 5 ms, faster than 86.03% of Java online submissions for Minimum Suffix Flips.
Memory Usage: 42.8 MB, less than 50.00% of Java online submissions for Minimum Suffix Flips.
*/
