/*
1370.
Increasing Decreasing String
https://leetcode.com/problems/increasing-decreasing-string/
*/

class Solution {
    public String sortString(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();  // keyset이 정렬된 상태가 되기 위해서 TreeMap을 사용
        StringBuilder mainSb = new StringBuilder();         // subSb를 모아서 toString
        StringBuilder subSb = new StringBuilder();          // 각 try마다 char들을 모아서 mainSb에 append
        for (char c : s.toCharArray()){                     // TreeMap 구축
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        boolean reversed = false;                           // 역방향 flag
        while (map.size() > 0) {
            for (char c : map.keySet().toArray(new Character[map.size()])) {
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
                
                subSb.append(c);
            }
            
            if (reversed) {
                subSb.reverse();
                reversed = false;
            } else {
                reversed = true;
            }
            
            mainSb.append(subSb);
            subSb.setLength(0);             // subSb 초기화
        }
        
        return mainSb.toString();
    }
}

/*
Runtime: 26 ms, faster than 6.00% of Java online submissions for Increasing Decreasing String.
Memory Usage: 41.9 MB, less than 5.52% of Java online submissions for Increasing Decreasing String.
*/

/*
다른 사람의 풀이

class Solution {
    public String sortString(String s) {
        int [] freq = new int[26];
        for (char ch: s.toCharArray()) {
            freq[ch - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int i=0; i<26; i++) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i] -= 1;
                }
            }
            for (int i=25; i>=0; i--) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i] -= 1;
                }
            }
        }
        return sb.toString();
    }
}

treemap을 이용하지 않고 정적 배열을 만들어서 아스키코드를 이용해 풀이하는 풀이다.
아무래도 정적 배열을 사용하기 때문에 시간복잡도나 공간복잡도가 효율적일듯싶다.

*/
