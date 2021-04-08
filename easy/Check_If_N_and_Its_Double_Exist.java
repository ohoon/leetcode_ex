/*
1346.
Check If N and Its Double Exist
https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
*/

class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int elem : arr) {                  // 해시맵을 구축하면서 2 * elem인 것과 elem // 2인 key가 있는지 검증
            if (map.containsKey(2 * elem) ||
                (elem % 2 == 0 && map.containsKey(elem / 2))) {
                return true;
            }
            
            map.put(elem, true);
        }
        
        return false;
    }
}

/*
Runtime: 1 ms, faster than 99.00% of Java online submissions for Check If N and Its Double Exist.
Memory Usage: 38.7 MB, less than 43.16% of Java online submissions for Check If N and Its Double Exist.
*/

/*
다른 사람의 풀이

public boolean checkIfExist(int[] arr) {
    Set<Integer> set = new HashSet();
    for (int n : arr) {
        if (set.contains(2*n) 
            || (n%2 == 0 && set.contains(n/2)))
            return true;
        set.add(n);
    }
    return false;
}

hashset을 이용한 풀이.
전체적으론 해시맵과 같지만 value처럼 의미없는 공간 낭비를 안해서 공간복잡도에서 더 효율적일듯

*/
