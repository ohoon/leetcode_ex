/*
1358.
Number of Substrings Containing All Three Characters
https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
*/

class Solution {
    public int numberOfSubstrings(String s) {       // sliding window
        int answer = 0;
        int n = s.length();
        int[] freq = new int[3];        // a, b, c의 빈도수
        for (int i = 0, j = 0; i < n; i++) {        // j번째 요소부터 i번째 요소까지를 window로 정함. i는 점점 커지면서 window 크기를 키움
            freq[s.charAt(i)-'a']++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {     // a, b, c가 하나씩 있으면 조건이 충족되는 만큼 j를 올리며 window 크기를 줄여나감
                answer += n-i;
                freq[s.charAt(j++)-'a']--;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 14 ms, faster than 54.00% of Java online submissions for Number of Substrings Containing All Three Characters.
Memory Usage: 44.6 MB, less than 71.20% of Java online submissions for Number of Substrings Containing All Three Characters.
*/
