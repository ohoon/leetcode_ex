/*
1935.
Maximum Number of Words You Can Type
https://leetcode.com/problems/maximum-number-of-words-you-can-type/
*/

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int answer = 0;
        boolean[] isBroken = new boolean[26];
        for (char letter : brokenLetters.toCharArray()) {
            isBroken[letter - 'a'] = true;      // brokenLetters에 있는 letter들을 isBroken에 표시
        }
        
        for (String word : text.split(" ")) {
            boolean isSuccess = true;
            for (char ch : word.toCharArray()) {
                if (isBroken[ch - 'a']) {       // brokenLetters에 있는 letter이 나오면 다음 word로 이동
                    isSuccess = false;
                    break;
                }
            }
            
            if (isSuccess) {                    // break되지 않고 정상적으로 for문이 끝나면 answer 증가
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 99.95% of Java online submissions for Maximum Number of Words You Can Type.
Memory Usage: 38.8 MB, less than 77.18% of Java online submissions for Maximum Number of Words You Can Type.
*/
