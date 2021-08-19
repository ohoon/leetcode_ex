/*
677.
Map Sum Pairs
https://leetcode.com/problems/map-sum-pairs/
*/

class MapSum {
    
    HashMap<String, Integer> map;
    
    TrieNode root;
    
    public MapSum() {
        map = new HashMap();
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);     // 기존 값과의 차이, offset만 더해줌
        map.put(key, val);
        TrieNode cur = root;
        cur.score += delta;
        for (char c: key.toCharArray()) {               // 한글자씩 trieNode를 탐색하며 score 갱신
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
            cur.score += delta;
        }
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c: prefix.toCharArray()) {
            cur = cur.children.get(c);
            if (cur == null) return 0;
        }
        
        return cur.score;
    }
    
}

class TrieNode {        // Trie 구현체
    Map<Character, TrieNode> children = new HashMap();      // 한글자씩 연결리스트처럼 map이 연결됨
    int score;
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

/*
Runtime: 12 ms, faster than 45.76% of Java online submissions for Map Sum Pairs.
Memory Usage: 38.9 MB, less than 79.41% of Java online submissions for Map Sum Pairs.
*/

/*
여담

내가 선택한 풀이 방식은 입력받는 key를 각각의 prefix마다 map에 등록하고 관리하는 bruteforce 방식이었다.
그렇다보니 시간적으로 비효율적이었고, 고민을 해보다가 이런 문제를 효율적으로 풀 수 있는 방법이 뭘까 궁금해서 솔루션을 찾아봤다.
결론은 trie라는 자료 구조를 응용하면 아주 효율적으로 풀 수 있는 문제였다.
이번 기회에 trie에 대해서 이해하고 내 것으로 만들어서 다시 도전해야겠다.

*/
