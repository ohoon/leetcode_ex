/*
2255.
Count Prefixes of a Given String
https://leetcode.com/problems/count-prefixes-of-a-given-string/
*/

class Solution {
    public int countPrefixes(String[] words, String s) {
        int answer = 0;
        for (String w : words) {
            if (s.startsWith(w)) {      // w이 s의 prefix라면 answer++
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Count Prefixes of a Given String.
Memory Usage: 43.7 MB, less than 33.33% of Java online submissions for Count Prefixes of a Given String.
*/
