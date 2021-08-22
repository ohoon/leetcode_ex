/*
1488.
Avoid Flood in The City
https://leetcode.com/problems/avoid-flood-in-the-city/
*/

class Solution {
    public int[] avoidFlood(int[] rains) {
        Set<Integer> fulls = new HashSet<>();       // 비로 가득 찬 강들
        Map<Integer, Deque<Integer>> map = new HashMap<>();     // 각 강마다 비가 오는 인덱스 맵
        PriorityQueue<Integer> heapq = new PriorityQueue<>();   // 가장 먼저 말려야하는 강을 뽑기 위한 heapq
        int[] answer = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {        // map을 채우기 위해서 각각의 강마다 비가 오는 인덱스를 기록
            if (rains[i] == 0) {
                continue;
            }
            
            if (map.containsKey(rains[i])) {
                map.get(rains[i]).addLast(i);
            } else {
                map.put(rains[i], new LinkedList<>());
            }
        }
        
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                if (!heapq.isEmpty()) {                 // heapq에서 가장 급하게 말려야할 강 인덱스를 가져와서 dry시킴
                    int dry = rains[heapq.poll()];
                    fulls.remove(dry);
                    answer[i] = dry;
                } else {
                    answer[i] = 1;
                }
                
                continue;
            }
            
            if (fulls.contains(rains[i])) {
                return new int[0];
            }
            
            if (map.containsKey(rains[i]) && !map.get(rains[i]).isEmpty()) {        // 해당 강에서 다음 비가 올 인덱스를 heapq에 삽입
                heapq.add(map.get(rains[i]).removeFirst());
            }
            
            fulls.add(rains[i]);
            answer[i] = -1;
        }
        
        return answer;
    }
}

/*
Runtime: 78 ms, faster than 30.38% of Java online submissions for Avoid Flood in The City.
Memory Usage: 63.7 MB, less than 13.85% of Java online submissions for Avoid Flood in The City.
*/

/*
다른 사람의 풀이

class Solution {
    public int[] avoidFlood(int[] rains) {
        // the previous appeared idx of rains[i]
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> zeros = new TreeSet<>();
        int[] res = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                zeros.add(i);
            } else {
                if (map.containsKey(rains[i])) {
                    // find the location of zero that can be used to empty rains[i]
                    Integer next = zeros.ceiling(map.get(rains[i]));
                    if (next == null) return new int[0];
                    res[next] = rains[i];
                    zeros.remove(next);
                }
                res[i] = -1;
				map.put(rains[i], i);
            }
        }
        for (int i : zeros) res[i] = 1;
        return res;
    }
}

문제 자체는 통과가 잘 됐지만 코드가 너무 지저분했고, 자료구조를 이것 저것 섞어서 쓴 것이 마음에 들지 않아서
다른 풀이는 어떻게 풀이했는지 찾아봤다.
위의 코드는 deque나 heapq없이 hashmap과 treeset만으로도 훌륭하게 풀이해냈다.
특히 treeset의 ceiling이라는 함수를 처음 봐서 인상깊었다.
ceiling 함수는 파라미터로 들어가는 값 이상에서 가장 가까운 값을 반환한다.
이 성질을 이용해서 비가 채워지지 않은 강에 dry하는 문제를 해결할 수 있다.

*/
