/*
2182.
Construct String With Repeat Limit
https://leetcode.com/problems/construct-string-with-repeat-limit/
*/

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c-'a']++;
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((x, y) -> (int) y - (int) x);
        for (char c = 'a'; c <= 'z'; c++) {
            if (freq[c-'a'] == 0) {
                continue;
            }

            pq.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char temp = '\0';
            if (sb.length() > 0 && pq.peek() == sb.charAt(sb.length()-1)) {
                temp = pq.poll();
            }

            if (temp != '\0' && pq.isEmpty()) {
                break;
            }
            
            char ch = pq.poll();
            if (temp != '\0') {
                sb.append(ch);
                if (--freq[ch-'a'] > 0) {
                    pq.offer(ch);
                }
            } else if (freq[ch-'a'] > repeatLimit) {
                for (int i = 0; i < repeatLimit; i++) {
                    sb.append(ch);
                }

                freq[ch-'a'] -= repeatLimit;
                pq.offer(ch);
            } else {
                for (int i = 0; i < freq[ch-'a']; i++) {
                    sb.append(ch);
                }

                freq[ch-'a'] = 0;
            }

            if (temp != '\0') {
                pq.offer(temp);
            }
        }

        return sb.toString();
    }
}
