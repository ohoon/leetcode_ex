/*
1317.
Convert Integer to the Sum of Two No-Zero Integers
https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
*/

class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] answer = new int[2];
        
        for (int i = 1; i <= n / 2; i++) {
            if (String.valueOf(i).indexOf('0') < 0 && String.valueOf(n - i).indexOf('0') < 0) {     // i와 n-i 모두 0이 없으면 answer에 대입 후에 break
                answer[0] = i;
                answer[1] = n - i;
                break;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Integer to the Sum of Two No-Zero Integers.
Memory Usage: 36.9 MB, less than 65.59% of Java online submissions for Convert Integer to the Sum of Two No-Zero Integers.
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
