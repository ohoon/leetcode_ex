/*
911.
Online Election
https://leetcode.com/problems/online-election/
*/

class TopVotedCandidate {
    private TreeMap<Integer, Integer> map;      // treemap.floorkey() 사용

    private int lead;       // 현재 최다 득표자

    private int[] vote;     // 투표 현황

    public TopVotedCandidate(int[] persons, int[] times) {
        int n = persons.length;
        map = new TreeMap<>();
        lead = 0;
        vote = new int[5001];
        for (int i = 0; i < n; i++) {
            if (++vote[persons[i]] >= vote[lead]) {
                lead = persons[i];
            }

            map.put(times[i], lead);
        }
    }
    
    public int q(int t) {
        return map.get(map.floorKey(t));
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
