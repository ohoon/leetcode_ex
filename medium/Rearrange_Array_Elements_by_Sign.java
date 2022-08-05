/*
2149.
Rearrange Array Elements by Sign
https://leetcode.com/problems/rearrange-array-elements-by-sign/
*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> pos = new LinkedList<>();        // 양수와 음수를 deq으로 따로 관리
        Deque<Integer> neg = new LinkedList<>();
        for (int n : nums) {
            if (n > 0) {
                pos.addLast(n);
            } else {
                neg.addLast(n);
            }
        }
        
        while (!pos.isEmpty() || !neg.isEmpty()) {
            if (pos.isEmpty()) {
                answer.add(neg.removeFirst());
                continue;
            }
            
            if (neg.isEmpty()) {
                answer.add(pos.removeFirst());
                continue;
            }
            
            if (answer.isEmpty() || answer.get(answer.size()-1) < 0) {
                answer.add(pos.removeFirst());
                continue;
            }
            
            answer.add(neg.removeFirst());
        }
        
        return answer.stream().mapToInt(v->v).toArray();
    }
}

/*
Runtime: 93 ms, faster than 5.17% of Java online submissions for Rearrange Array Elements by Sign.
Memory Usage: 223.9 MB, less than 46.70% of Java online submissions for Rearrange Array Elements by Sign.
*/
