/*
1524.
Number of Sub-arrays With Odd Sum
https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
*/

class Solution {
    public int numOfSubarrays(int[] arr) {
        long ans = 0, odd = 0, even = 0;        // 홀수와 짝수 갯수를 누적해서 변수로 보관
        for (int num : arr) {
            if (num % 2 == 0) {     // 짝수의 경우에는 odd sum에 영향을 주지 않기 때문에 단순히 even의 카운팅을 올려주기만 함
                even ++;
            } else {                // 홀수의 경우에는 odd sum에 영향을 주기 때문에(홀수가 홀수 개여야 홀수 합이 됨)
                long temp = even;   // 현재 요소 기준으로 누적된 짝수만큼 odd sum subarray가 존재
                even = odd;         // 그리고 난후, 다음 요소부터의 짝수들이 odd sum에 영향을 주므로 두 변수를 swap
                odd = temp;
                odd++;              // 자기 자신이 홀수이므로 더해줌
            }
            ans += odd;
        }
        return (int)(ans % (Math.pow(10, 9) + 7));
    }
}

/*
Runtime: 7 ms, faster than 98.59% of Java online submissions for Number of Sub-arrays With Odd Sum.
Memory Usage: 48.8 MB, less than 55.06% of Java online submissions for Number of Sub-arrays With Odd Sum.
*/

/*
여담

처음엔 그냥 단순히 누적값을 기록하면서 (0~i까지의 누적값 - 0~j까지의 누적값)으로 (i~j까지의 누적값)을 구하여 풀이했었다.
하지만 이렇게 풀면 arr의 길이가 10의 5승이기때문에 시간 초과가 나게 되어서 쓸데없는 연산을 제거할 필요성을 느꼈다.
그래서 홀수의 개수만 알면 odd sum인지 아닌지 알 수 있겠다 생각이 들어서 코드를 수정했다.
하지만 결국에는 시간 복잡도가 n의 2승에 달해서 여전히 시간 초과에 걸렸다.
근본적으로 탐색을 n의 제곱이 아닌 n으로 할 순 없을까 고민을 많이 했다.
많이 고민했지만 별 다른 생각이 떠오르지 않아 풀이를 보면서 공부하기로 결심했다.
다른 사람의 풀이에서는 dp방법으로 O(N)의 시간복잡도로 가졌다.
odd와 even 개수를 계속해서 누적시키면서 swap해가는 과정이 흥미로웠고 좀 더 풀이의 시야가 넓어진 것 같음
*/
