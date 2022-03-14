/*
784.
Letter Case Permutation
https://leetcode.com/problems/letter-case-permutation/
*/

class Solution {
    private void backtrack(StringBuilder sb, String s, int index, List<String> answer) {        // backtrack용 메서드
        if (index == s.length()) {      // 모든 문자열이 stringbuilder에 삽입되면 answer에 결과 문자열을 넣고 종료
            answer.add(sb.toString());
            return;
        }
        
        sb.append(Character.toLowerCase(s.charAt(index)));      // 소문자 처리
        backtrack(sb, s, index + 1, answer);
        sb.deleteCharAt(index);
        if (!Character.isLetter(s.charAt(index))) {             // digit의 경우에는 대문자처리를 따로 하지 않음
            return;
        }
        
        sb.append(Character.toUpperCase(s.charAt(index)));      // 대문자 처리
        backtrack(sb, s, index + 1, answer);
        sb.deleteCharAt(index);
    }
    
    public List<String> letterCasePermutation(String s) {
        List<String> answer = new ArrayList<>();
        backtrack(new StringBuilder(), s, 0, answer);
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 87.62% of Java online submissions for Letter Case Permutation.
Memory Usage: 53.3 MB, less than 56.62% of Java online submissions for Letter Case Permutation.
*/
