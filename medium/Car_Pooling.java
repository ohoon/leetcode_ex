/*
1094.
Car Pooling
https://leetcode.com/problems/car-pooling/
*/

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] drop = new int[1001];     // i km에 내려줘야 할 사람 수를 담은 배열
        int curr = 0;       // 현재 km
        Arrays.sort(trips, (t1, t2) -> t1[1] - t2[1]);  // 승객이 타는 위치 기준으로 오름차순 정렬
        for (int[] t : trips) {
            while (curr <= t[1]) {          // 승객이 타는 위치까지 운행(하차만 신경쓰면 됨)
                capacity += drop[curr++];
            }
            
            if (capacity < t[0]) {          // 더 이상 자리가 없으면 false 반환
                return false;
            }
            
            capacity -= t[0];               // 승객이 탑승
            drop[t[2]] += t[0];             // 내려야할 곳에 대한 정보를 drop 배열에 저장
        }
        
        return true;
    }
}

/*
Runtime: 3 ms, faster than 71.48% of Java online submissions for Car Pooling.
Memory Usage: 38.9 MB, less than 65.29% of Java online submissions for Car Pooling.
*/
