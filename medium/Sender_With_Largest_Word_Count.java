/*
2284.
Sender With Largest Word Count
https://leetcode.com/problems/sender-with-largest-word-count/
*/

class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        String answer = senders[0];
        Map<String, Integer> map = new HashMap<>();
        map.put(senders[0], messages[0].split(" ").length);
        for (int i = 1; i < senders.length; i++) {
            map.put(senders[i], map.getOrDefault(senders[i], 0) + messages[i].split(" ").length);       // word 개수 카운팅
            if (map.get(senders[i]) == map.get(answer) && senders[i].compareTo(answer) > 0) {           // 최고값이 같으면 사전 기준으로
                answer = senders[i];
                continue;
            }

            if (map.get(senders[i]) > map.get(answer)) {        // word 개수가 가장 많은 sender 
                answer = senders[i];
                continue;
            }
        }

        return answer;
    }
}
