/*
841.
Keys and Rooms
https://leetcode.com/problems/keys-and-rooms/
*/

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] keys = new boolean[rooms.size()];
        dfs(rooms, 0, keys);
        for (boolean key : keys) {
            if (!key) {
                return false;
            }
        }
        
        return true;
    }
    
    private void dfs(List<List<Integer>> rooms, int curr, boolean[] keys) {
        if (keys[curr]) {
            return;
        }
        
        keys[curr] = true;
        for (int key : rooms.get(curr)) {
            dfs(rooms, key, keys);
        }
    }
}

/*
Runtime: 2 ms, faster than 51.08% of Java online submissions for Keys and Rooms.
Memory Usage: 41.9 MB, less than 15.95% of Java online submissions for Keys and Rooms.
*/
