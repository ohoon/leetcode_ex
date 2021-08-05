/*
93.
Restore IP Addresses
https://leetcode.com/problems/restore-ip-addresses/
*/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> answer = new ArrayList<>();
        backtrack(s, 0, new ArrayList<String>(), answer);
        return answer;
    }
    
    private void backtrack(String s, int cur, List<String> ip, List<String> answer) {
        if (ip.size() == 4 && cur >= s.length()) {
            answer.add(String.join(".", ip));
            return;
        }
        
        if (ip.size() == 4 || cur >= s.length()) {
            return;
        }
        
        for (int i = 1; i <= 3; i++) {
            if (cur + i > s.length()) {
                return;
            }
            
            String substr = s.substring(cur, cur+i);
            if ((substr.length() > 1 && substr.charAt(0) == '0') || Integer.valueOf(substr) > 255) {
                return;
            }
            
            ip.add(substr);
            backtrack(s, cur+i, ip, answer);
            ip.remove(ip.size()-1);
        }
    }
}

/*
Runtime: 2 ms, faster than 83.99% of Java online submissions for Restore IP Addresses.
Memory Usage: 38.7 MB, less than 92.92% of Java online submissions for Restore IP Addresses.
*/

/*
여담

백트래킹으로 순회하면서 각 substr이 255를 넘진 않는지 0으로 시작되진 않는지 체크해야하는 조건들이 많아서 구현하기 까다로웠음..

*/
