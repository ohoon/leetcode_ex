/*
1704.
Determine if String Halves Are Alike
https://leetcode.com/problems/determine-if-string-halves-are-alike/
*/

class Solution {
    public boolean halvesAreAlike(String s) {
        List<Character> vowels = new ArrayList<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        );

        int a = 0;
        int b = 0;

        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {     // i는 처음부터 j는 끝부터 탐색하여 중간에서 만남
            if (vowels.indexOf(s.charAt(i)) > -1) {
                a++;
            }

            if (vowels.indexOf(s.charAt(j)) > -1) {
                b++;
            }
        }

        return a == b;
    }
}

/*
Runtime: 4 ms, faster than 32.13% of Java online submissions for Determine if String Halves Are Alike.
Memory Usage: 37.5 MB, less than 37.35% of Java online submissions for Determine if String Halves Are Alike.
*/

/*
다른 사람의 풀이

class Solution {
    public int[] getNoZeroIntegers(int n) {
        n--;
        int m=1;
        int ans[]={m,n};
        
        while(contains(ans[0])==true || contains(ans[1])==true){
            ans[0]++;
            ans[1]--;
        }
        
        return ans;
    }
    public boolean contains(int n){
        boolean flag=false;
        while(n!=0){
            if(n%10==0)
                return true;
            n=n/10;
        }
        return false;
    }
}

다른 사람들은 대부분 0이 있는지의 검증을 나머지 연산으로 처리한다는 것을 볼 수 있었다.
물론 나도 처음엔 그런 방법으로 풀까 생각했지만 문자열로 바꿔서 indexOf로 체크하는 것이 코드를 이해하는 데는 더 좋다고 느껴져서
문자열 방법을 사용했다. 속도도 물론 나머지 연산에 비해 꿇리지도 않는다.

*/
