/*
692.
Top K Frequent Words
https://leetcode.com/problems/top-k-frequent-words/
*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(     // 우선순위 큐
            (x, y) -> (map.get(x) == map.get(y) ? x.compareTo(y) : map.get(y) - map.get(x))     // 빈도수가 같으면 사전순, 다르면 빈도순
        );
        
        for (String word : words) {     // 빈도수 카운팅
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for (String word : map.keySet()) {
            pq.offer(word);
        }
        
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            answer.add(pq.poll());
        }
        
        return answer;
    }
}
