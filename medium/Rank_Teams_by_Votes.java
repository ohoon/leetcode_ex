/*
1366.
Rank Teams by Votes
https://leetcode.com/problems/rank-teams-by-votes/
*/

class Solution {
    public String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();        // 알파벳별로 각 위치에 해당하는 갯수를 저장하는 해시맵
        int len = votes[0].length();
        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < len; j++) {
                char chr = votes[i].charAt(j);
                if (map.containsKey(chr)) {
                    map.get(chr)[j]++;
                } else {
                    int[] arr = new int[len];
                    arr[j] = 1;
                    map.put(chr, arr);
                }
            }
        }
        
        Character[] answer = votes[0].chars().mapToObj(c -> (char) c).toArray(Character[]::new);        // votes의 첫번째 vote를 기준으로 Character Array 변환
        Arrays.sort(answer, (s1, s2) -> {       // 위의 해시맵을 참고하여 첫번째 위치부터 마지막 위치까지 갯수가 많은 순서대로 정렬
            for (int i = 0; i < len; i++) {
                int v1 = map.get(s1)[i];
                int v2 = map.get(s2)[i];
                if (v1 == v2) {
                    continue;
                }
                
                return v2 - v1;
            }
            
            return s1 - s2;
        });
        
        return Arrays.stream(answer).map(String::valueOf).collect(Collectors.joining());
    }
}

/*
Runtime: 12 ms, faster than 60.26% of Java online submissions for Rank Teams by Votes.
Memory Usage: 39.1 MB, less than 61.92% of Java online submissions for Rank Teams by Votes.
*/
