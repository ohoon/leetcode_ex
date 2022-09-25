/*
2418.
Sort the People
https://leetcode.com/problems/sort-the-people/
*/

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        int n = names.length;
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }
        
        Arrays.sort(heights);
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[n-i-1] = map.get(heights[i]);
        }
        
        return answer;
    }
}

/*
Runtime: 13 ms, faster than 80.00% of Java online submissions for Sort the People.
Memory Usage: 54.5 MB, less than 80.00% of Java online submissions for Sort the People.
*/
