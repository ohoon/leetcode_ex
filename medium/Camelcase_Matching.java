/*
1023.
Camelcase Matching
https://leetcode.com/problems/camelcase-matching/
*/

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> answer = new ArrayList<>();
        for (String q : queries) {
            boolean isMatch = true;
            int cur = 0;
            for (char c : pattern.toCharArray()) {
                while (true) {
                    if (cur == q.length() || (q.charAt(cur) != c && q.charAt(cur) < 'a')) {
                        isMatch = false;
                        break;
                    }

                    if (q.charAt(cur++) == c) {
                        break;
                    }
                }

                if (!isMatch) {
                    break;
                }
            }

            for (int i = cur; i < q.length(); i++) {
                if (q.charAt(i) < 'a') {
                    isMatch = false;
                    break;
                }
            }

            answer.add(isMatch);
        }

        return answer;
    }
}
