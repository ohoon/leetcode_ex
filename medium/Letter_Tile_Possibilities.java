/*
1079.
Letter Tile Possibilities
https://leetcode.com/problems/letter-tile-possibilities/
*/

class Solution {
    private void dfs(String tiles, String str, int[] count, Set<String> set) {      // backtrack
        for (int i = 0; i < tiles.length(); i++) {
            char c = tiles.charAt(i);
            if (count[c-'A'] == 0) {        // 남은 수량이 없는 타일은 패스
                continue;
            }
            
            count[c-'A']--;
            set.add(str + c);       // 현재 타일을 선택하는 경우의 수 선택
            dfs(tiles, str+c, count, set);
            count[c-'A']++;
        }
    }
    
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {        // 타일별로 개수 기록
            count[c-'A']++;
        }
        
        dfs(tiles, "", count, set);
        return set.size();
    }
}

/*
Runtime: 369 ms, faster than 5.02% of Java online submissions for Letter Tile Possibilities.
Memory Usage: 72.1 MB, less than 5.02% of Java online submissions for Letter Tile Possibilities.
*/
