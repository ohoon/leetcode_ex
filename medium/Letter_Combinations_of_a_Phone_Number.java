/*
17.
Letter Combinations of a Phone Number
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<String>();
        String[] buttons = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combi(answer, digits, buttons, "");
        return answer;
    }
    
    public void combi(List<String> answer, String digits, String[] buttons, String result) {
        if (result.length() == digits.length()) {
            if (!result.isEmpty()) {
                answer.add(result);
            }
            
            return;
        }
        
        int digit = digits.charAt(result.length()) - '0';
        String letters = buttons[digit - 2];
        for (int i = 0; i < letters.length(); i++) {
            combi(answer, digits, buttons, result + letters.charAt(i));
        }
    }
}

/*
Runtime: 4 ms, faster than 43.03% of Java online submissions for Letter Combinations of a Phone Number.
Memory Usage: 39.1 MB, less than 37.93% of Java online submissions for Letter Combinations of a Phone Number.
*/
