/*
1189.
Maximum Number of Balloons
https://leetcode.com/problems/distance-between-bus-stops/
*/

class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);
        
        for (int i = 0; i < text.length(); i++) {
            char key = text.charAt(i);
            if (key == 'b' || key == 'a' || key == 'l' || key == 'o' || key == 'n')
                map.put(key, map.get(key) + 1);
        }
        
        int answer = map.get('b');
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {            // 해시맵 탐색
            char key = entry.getKey();
            int value = entry.getValue();
            if (key == 'l' || key == 'o') {
              answer = Math.min(answer, (int) (value / 2));  
            } else {
              answer = Math.min(answer, value);  
            }
        }
        
        return answer;
    }
}

/*
Runtime: 4 ms, faster than 39.97% of Java online submissions for Maximum Number of Balloons.
Memory Usage: 38.5 MB, less than 61.33% of Java online submissions for Maximum Number of Balloons.
*/
