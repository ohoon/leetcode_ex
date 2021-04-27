/*
1539.
Kth Missing Positive Number
https://leetcode.com/problems/kth-missing-positive-number/
*/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int[] num = new int[1000];
        for (int a : arr) {         // arr에 있는 숫자는 num에서 1로 표시
            num[a-1] = 1;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 0 && --k == 0) {      // num에 1이 된 숫자를 제외하고 k번째 인덱스를 탐색
                return i + 1;
            }
        }
        
        return 1000 + k;                        // 1000을 초과하면 나머지 k를 더해서 반환
    }
}

/*
Runtime: 1 ms, faster than 22.83% of Java online submissions for Kth Missing Positive Number.
Memory Usage: 40.7 MB, less than 5.25% of Java online submissions for Kth Missing Positive Number.
*/

/*
다른 사람의 풀이

public int findKthPositive(int[] arr, int k) {
    for(int i=0;i<arr.length;i++) {
        if(arr[i]<=k) {
            k++;
        } else {
            break;
        }
    }
    return k;
}

arr의 각 숫자와 k를 비교해서 k 이하인 숫자가 나올때마다 k를 증가시킨다.
왜냐하면 1~n~k인 상황이면 n을 제외하고 k개여야 하므로 1~n~k+1이 되어야 k개가 될 것이기 때문에
이 방법은 따로 공간을 잡아먹지도 않고 원패스로 해결할 수 있는 최적 풀이라고 생각한다.

*/
