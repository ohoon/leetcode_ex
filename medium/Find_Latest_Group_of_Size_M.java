/*
1562.
Find Latest Group of Size M
https://leetcode.com/problems/find-latest-group-of-size-m/
*/

class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if(m == n) {        // arr의 길이와 m이 같으면 마지막 step에 조건을 성립함
            return n;
        }
        
        TreeSet<Integer> walls = new TreeSet<Integer>();        // floor, ceiling 메서드를 이용하기 위해서 treeset을 사용
        walls.add(0);       // 비트가 1이 아닌 것들 즉, 경계 역할을 하는 인덱스들을 set안에 삽입
        walls.add(n+1);
        for(int i = n-1; i >= 0; i--) {
            int left = walls.floor(arr[i]);     // treeset 안의 값들 중에 arr[i]와 가장 가까운 값(left, right)들을 가져옴
            int right = walls.ceiling(arr[i]);
            if(arr[i] - left - 1 == m || right - arr[i] - 1 == m) {     // left~arr[i], arr[i]~right으로 쪼갠 후에 길이가 m과 같다면 step 수를 반환
                return i;
            }
            
            walls.add(arr[i]);      // arr[i]번째 비트는 0이 되어 경계역할을 하기 때문에 treeset에 삽입
        }
        
        return -1;
    }
}

/*
Runtime: 545 ms, faster than 5.61% of Java online submissions for Find Latest Group of Size M.
Memory Usage: 122.9 MB, less than 18.69% of Java online submissions for Find Latest Group of Size M.
*/

/*
여담

어떻게 풀어야 할지 감이 잘 안와서 다른 사람 풀이를 참고하였는데,
TreeSet을 많이 사용해봤다면 쉽게 풀 수 있었던 문제였다.
tree의 특성 상 연속되는 값들의 양쪽 가장자리를 빠르게 참조할 수 있어서 이 문제를 풀기 적합한 것 같다.
유용한 메서드니 꼭 기억하고 다음에는 사용해보자.

*/
