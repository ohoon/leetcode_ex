/*
1781.
Sum of Beauty of All Substrings
https://leetcode.com/problems/sum-of-beauty-of-all-substrings/
*/

class Solution {
    private int getMostFreq(int[] freq) {       // 가장 큰 빈도수를 반환하는 메서드
        int result = 0;
        for (int f : freq) {
            result = Math.max(result, f);
        }
        
        return result;
    }
    
    private int getLeastFreq(int[] freq) {      // 가장 작은 빈도수를 반환하는 메서드
        int result = Integer.MAX_VALUE;
        for (int f : freq) {
            if (f == 0) {
                continue;
            }
            
            result = Math.min(result, f);
        }
        
        return result;
    }
    
    public int beautySum(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < s.length(); j++) {      // 각 문자별로 빈도수를 증가
                freq[s.charAt(j) - 'a']++;
                answer += getMostFreq(freq) - getLeastFreq(freq);
            }
        }
        
        return answer;
    }
}

/*
Runtime: 156 ms, faster than 27.50% of Java online submissions for Sum of Beauty of All Substrings.
Memory Usage: 43.3 MB, less than 37.50% of Java online submissions for Sum of Beauty of All Substrings.
*/
