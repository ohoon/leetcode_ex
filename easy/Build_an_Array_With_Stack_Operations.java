/*
1441.
Build an Array With Stack Operations
https://leetcode.com/problems/build-an-array-with-stack-operations/
*/

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> answer = new ArrayList<>();
        int cur = 1;
        for (int num : target) {
            while (cur < num) {             // num에 도달할때까지 Push Pop
                answer.add("Push");
                answer.add("Pop");
                cur++;

            }
            
            answer.add("Push");             // Push 입력하고 다음 num으로
            cur++;

        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Build an Array With Stack Operations.
Memory Usage: 39.6 MB, less than 8.80% of Java online submissions for Build an Array With Stack Operations.
*/
