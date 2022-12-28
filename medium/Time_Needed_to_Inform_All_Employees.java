/*
1376.
Time Needed to Inform All Employees
https://leetcode.com/problems/time-needed-to-inform-all-employees/
*/

class Solution {            // DFS
    private int dfs(int id, int[] informTime, Map<Integer, List<Integer>> map) {
        if (!map.containsKey(id)) {
            return 0;
        }

        int requiredTime = 0;
        for (int nextId : map.get(id)) {
            requiredTime = Math.max(requiredTime, dfs(nextId, informTime, map));        // 직속 부하들의 informTime의 최대치만큼 시간을 사용
        }

        return requiredTime + informTime[id];       // 직속 부하가 쓴 시간 + 직속 부하에게 쓰는 소개 시간
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i == headID) {
                continue;
            }

            if (!map.containsKey(manager[i])) {
                map.put(manager[i], new ArrayList<>());
            }

            map.get(manager[i]).add(i);
        }

        return dfs(headID, informTime, map);
    }
}
