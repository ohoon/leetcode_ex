/*
139.
Word Break
https://leetcode.com/problems/word-break/
*/

class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[n]=true;
        Set<String> dict=new HashSet(wordDict);
        for(int i=n-1;i>=0;i--) {       // 뒤에서부터 접근
            for(int j=i+1;!dp[i] && j<=n;j++) {
                dp[i] = dp[j] & dict.contains(s.substring(i,j));
            }
        }
        return dp[0];   
    }
}

/*
Runtime: 7 ms, faster than 40.40% of Java online submissions for Word Break.
Memory Usage: 39.5 MB, less than 35.65% of Java online submissions for Word Break.
*/

/*
나의 풀이

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return sub(s, new HashSet<String>(wordDict), 0, 0);
    }
    
    private boolean sub(String s, Set<String> dict, int start, int cur) {
        if (cur >= s.length()) {
            return start >= s.length();
        }
        
        String str = s.substring(start, cur+1);
        if (dict.contains(str) && sub(s, dict, cur+1, cur+1)) {
            return true;
        }
        
        return sub(s, dict, start, cur+1);
    }
}

dp가 아닌 brute force로 풀이하다보니 시간 초과가 뜨는 테스트케이스가 있어서 문제를 풀지 못했음
위의 정석 풀이처럼 뒤에서부터 접근해서 각 결과값을 메모이제이션하여 재사용하는 것으로 최적화를 하는 것이 필요했다.

*/
