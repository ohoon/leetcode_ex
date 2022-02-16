/*
898.
Bitwise ORs of Subarrays
https://leetcode.com/problems/bitwise-ors-of-subarrays/
*/

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> answer = new HashSet<>();  // 모든 or 결과값들을 담기위한 hashset
        Set<Integer> set = new HashSet<>();     // subarray를 추출하기 위한 hashset
        for (int n : arr) {
            for (int m : new ArrayList<>(set)) {        // 이전 subarray를 가져와서 현재 숫자와 or 연산
                set.remove(m);
                set.add(n|m);
            }
            
            set.add(n);     // 자기 자신만을 가지는 subarray 처리
            answer.addAll(set);     // or 연산 결과값을 answer에 추가
        }
        
        return answer.size();
    }
}

/*
Runtime: 814 ms, faster than 28.19% of Java online submissions for Bitwise ORs of Subarrays.
Memory Usage: 229.4 MB, less than 30.87% of Java online submissions for Bitwise ORs of Subarrays.
*/
