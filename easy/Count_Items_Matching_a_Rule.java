/*
1773.
Count Items Matching a Rule
https://leetcode.com/problems/count-items-matching-a-rule/
*/

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int cur;
        switch (ruleKey) {          // ruleKey에 따라 참조할 인덱스 결정
            case "type":
                cur = 0;
                break;
            case "color":
                cur = 1;
                break;
            case "name":
                cur = 2;
                break;
            default:
                return -1;
        }
        
        int answer = 0;
        for (List<String> item : items) {
            if (item.get(cur).equals(ruleValue)) {      // 참조 인덱스에 해당하는 값이 ruleValue와 같으면 answer 증가
                answer++;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 3 ms, faster than 96.83% of Java online submissions for Count Items Matching a Rule.
Memory Usage: 43.5 MB, less than 80.26% of Java online submissions for Count Items Matching a Rule.
*/
