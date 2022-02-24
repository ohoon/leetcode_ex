/*
1593.
Split a String Into the Max Number of Unique Substrings
https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
*/

class Solution {
    private int answer = 0;
    
    public void backtrack(String s, int start, Set<String> set) {       // backtracking
        String str = "";
        for (int i = start; i < s.length(); i++) {      // start부터 한 문자씩 더해감
            str += s.charAt(i);
            if (set.contains(str)) {        // 중복되는 문자열은 건너뜀
                continue;
            }
            
            set.add(str);
            backtrack(s, i+1, set);         // 현재 str을 채택했을 경우로 순회
            set.remove(str);                
        }
        
        answer = Math.max(answer, set.size());
    }
    
    public int maxUniqueSplit(String s) {
        backtrack(s, 0, new HashSet<String>());
        return answer;
    }
}

/*
Runtime: 119 ms, faster than 18.30% of Java online submissions for Split a String Into the Max Number of Unique Substrings.
Memory Usage: 70.1 MB, less than 25.84% of Java online submissions for Split a String Into the Max Number of Unique Substrings.
*/
