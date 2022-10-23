/*
2446.
Determine if Two Events Have Conflict
https://leetcode.com/problems/determine-if-two-events-have-conflict/
*/

class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        String[] ev1Start = event1[0].split(":");
        String[] ev1End = event1[1].split(":");
        String[] ev2Start = event2[0].split(":");
        String[] ev2End = event2[1].split(":");
        return (Integer.valueOf(ev1End[0]) > Integer.valueOf(ev2Start[0]) || 
            (Integer.valueOf(ev1End[0]) == Integer.valueOf(ev2Start[0]) && 
             Integer.valueOf(ev1End[1]) >= Integer.valueOf(ev2Start[1]))
        ) && 
            (Integer.valueOf(ev2End[0]) > Integer.valueOf(ev1Start[0]) || 
            (Integer.valueOf(ev2End[0]) == Integer.valueOf(ev1Start[0]) && 
             Integer.valueOf(ev2End[1]) >= Integer.valueOf(ev1Start[1])));
    }
}

/*
Runtime: 1 ms, faster than 90.00% of Java online submissions for Determine if Two Events Have Conflict.
Memory Usage: 39.8 MB, less than 70.00% of Java online submissions for Determine if Two Events Have Conflict.
*/
