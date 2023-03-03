/*
767.
Reorganize String
https://leetcode.com/problems/reorganize-string/
*/

class Solution {
    public String reorganizeString(String s) {      // 우선순위큐
        int[] freq = new int[26];
        PriorityQueue<Character> pq = new PriorityQueue<>((x, y) -> freq[x-'a'] == freq[y-'a'] ? x - y : freq[y-'a'] - freq[x-'a']);
        for (char c : s.toCharArray()) {
            freq[c-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }

            pq.offer((char) ('a' + i));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            sb.append(c);
            freq[c-'a']--;
            if (freq[c-'a'] > 0 && pq.isEmpty()) {
                return "";
            }

            if (!pq.isEmpty()) {
                char c2 = pq.poll();
                sb.append(c2);
                if (--freq[c2-'a'] > 0) {
                    pq.offer(c2);
                }
            }

            if (freq[c-'a'] > 0) {
                pq.offer(c);
            }
        }

        return sb.toString();
    }
}
