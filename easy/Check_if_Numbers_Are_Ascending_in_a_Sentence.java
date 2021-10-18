/*
2042.
Check if Numbers Are Ascending in a Sentence
https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/
*/

class Solution {
    public boolean areNumbersAscending(String s) {
        int prev = -1;
        for (String token : s.split(" ")) {
            try {
                int curr = Integer.parseInt(token);     // int 타입으로 변환
                if (prev < curr) {
                    prev = curr;
                } else {
                    return false;
                }
            } catch (NumberFormatException err) {       // token이 숫자가 아니면 무시
                continue;
            }
        }
        
        return true;
    }
}

/*
Runtime: 5 ms, faster than 28.57% of Java online submissions for Check if Numbers Are Ascending in a Sentence.
Memory Usage: 39.7 MB, less than 28.57% of Java online submissions for Check if Numbers Are Ascending in a Sentence.
*/
