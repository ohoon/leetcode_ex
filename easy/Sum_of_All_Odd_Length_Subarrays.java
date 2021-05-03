/*
1588.
Sum of All Odd Length Subarrays
https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
*/

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] acc = new int[arr.length];            // 누적값 저장소
        acc[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {      // 누적값 저장
            acc[i] = acc[i-1] + arr[i];
        }
        
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j += 2) {       // i에서 부터 2씩 범위를 증가시켜 합을 구하여 answer에 추가
                if (i > 0) {
                    answer += acc[i+j] - acc[i-1];              // i+j까지의 누적값 - i-1까지의 누적값 = i부터 i+j까지의 합
                } else {
                    answer += acc[i+j];
                }
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 70.27% of Java online submissions for Sum of All Odd Length Subarrays.
Memory Usage: 36.2 MB, less than 97.79% of Java online submissions for Sum of All Odd Length Subarrays.
*/

/*
다른 사람의 풀이

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += (arr[i] * ((((i + 1) * (arr.length - i)) + 1) / 2));
        return sum;
    }
}

길이가 1일때, 2일때 나열하다보면 생기는 규칙을 가지고 공식을 만들어서 풀이한 방법이다.
물론 수학적 공식으로 해결할 수 있으면 시간적으로도 공간적으로도 극히 효율적이겠지만
정말 효율적이고 유일한 방법이 아닌 이상 쉽게 이해할 수 있는 코드가 더 좋다고 난 생각한다.

*/
