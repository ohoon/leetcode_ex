/*
2309.
Greatest English Letter in Upper and Lower Case
https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/
*/

class Solution {
    public String greatestLetter(String s) {
        String answer = "";
        boolean[] lower = new boolean[26];      // 알파벳 소문자 존재 여부 확인용
        boolean[] upper = new boolean[26];      // 알파벳 대문자 존재 여부 확인용
        for (char c : s.toCharArray()) {
            int index = -1;
            if (Character.isLowerCase(c)) {     // 각 알파벳이 대문자인지 소문자인지에 따라 lower[], upper[] 처리
                index = c - 'a';
                lower[index] = true;
            } else {
                index = c - 'A';
                upper[index] = true;
            }
            
            if (index > -1 && lower[index] && upper[index]) {
                if (answer.isEmpty()) {     // answer이 비었으면 바로 answer에 대입
                    answer = String.valueOf(Character.toUpperCase(c));
                    continue;
                }
                
                answer = String.valueOf((char) Math.max(answer.charAt(0), Character.toUpperCase(c)));       // answer과 비교하여 사전 기준으로 큰 알파벳이 오도록 대입
            }
        }
        
        return answer;
    }
}

/*
Runtime: 9 ms, faster than 50.00% of Java online submissions for Greatest English Letter in Upper and Lower Case.
Memory Usage: 44.5 MB, less than 25.00% of Java online submissions for Greatest English Letter in Upper and Lower Case.
*/
