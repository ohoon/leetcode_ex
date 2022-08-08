/*
2363.
Merge Similar Items
https://leetcode.com/problems/merge-similar-items/
*/

class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new TreeMap<>();        // 키 값이 오름차순으로 정렬되어야 하므로 treemap 사용
        for (int[] item : items1) {
            map.put(item[0], item[1]);
        }
        
        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        
        List<List<Integer>> answer = new ArrayList<>();
        for (int val : map.keySet()) {
            List<Integer> mergedItem = new ArrayList<>();
            mergedItem.add(val);
            mergedItem.add(map.get(val));
            answer.add(mergedItem);
        }
        
        return answer;
    }
}

/*
Runtime: 16 ms, faster than 33.33% of Java online submissions for Merge Similar Items.
Memory Usage: 55 MB, less than 16.67% of Java online submissions for Merge Similar Items.
*/
