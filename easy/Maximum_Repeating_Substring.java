/*
1668.
Maximum Repeating Substring
https://leetcode.com/problems/maximum-repeating-substring/
*/

class Solution {
    public int maxRepeating(String sequence, String word) {
        int answer = 0;
        int cur = 0;
        while (cur < sequence.length()) {
            int temp = cur;
            int count = 0;
            boolean isGood = true;
            while (temp <= sequence.length() - word.length()) {
                for (int i = 0; i < word.length(); i++) {
                    if (sequence.charAt(temp+i) != word.charAt(i)) {
                        isGood = false;
                        break;
                    }
                }

                if (isGood) {
                    temp += word.length();
                    count++;
                } else {
                    break;
                }
            }

            cur++;
            answer = Math.max(answer, count);
        }

        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Repeating Substring.
Memory Usage: 37 MB, less than 82.41% of Java online submissions for Maximum Repeating Substring.
*/
