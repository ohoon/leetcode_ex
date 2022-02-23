/*
1567.
Maximum Length of Subarray With Positive Product
https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
*/

class Solution {
    public int getMaxLen(int[] nums) {
        int positive = 0, negative = 0;     // 현재 양수로써의 길이와 음수로써의 길이를 나타내는 변수
        int answer = 0;
        for (int x : nums) {
            if (x == 0)  {                  // 0을 만나면 두 변수를 초기화
                positive = 0;
                negative = 0;
            } else if (x > 0) {             // 양수를 만나면 positive를 증가시키고 negative가 0을 초과할 때(이전에 음수를 만나서 negative가 적립되고 있는 상태)도 마찬가지로 증가
                positive++;
                negative = negative == 0 ? 0  : negative + 1;
            } else {                        // 음수를 만나면 positive와 negative를 반전시킨다. 두 변수의 값을 증가시키는 것은 양수때와 동일
                int temp = positive;
                positive = negative == 0 ? 0  : negative + 1;
                negative = temp + 1;
            }
            
            answer = Math.max(answer, positive);        // 양수 기준으로 길이를 비교하여 최대값을 알아낸다.
        }
        
        return answer;
    }
}

/*
Runtime: 5 ms, faster than 58.06% of Java online submissions for Maximum Length of Subarray With Positive Product.
Memory Usage: 83.9 MB, less than 12.36% of Java online submissions for Maximum Length of Subarray With Positive Product.
*/

/*
여담

주석만으로는 이해하기 힘들 것이라 생각이 드는데, 위의 코드를 작성한 사람이 든 예시를 보면 이해가 쉬울 듯 싶다.

elements      :   9    5    8    2    -6    4    -3    0    2    -5    15    10    -7    9    -2
positive_len  :   1    2    3    4     0    1     7    0    1     0     1     2     5    6     5
negative_len  :   0    0    0    0     5    6     2    0    0     2     3     4     3    4     7

현재 길이 상태를 가지는 변수를 positive, negative 2개를 두고 적립시키면서 음수를 만나면 서로 뒤집어주는 방법으로 이 문제를 해결한다.
이것과 비슷한 방법으로 푸는 문제를 한번 봤었던 것 같은데, 이 방법을 익혀놓으면 여러모로 좋을 것 같다.

*/
