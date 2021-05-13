/*
1710.
Maximum Units on a Truck
https://leetcode.com/problems/maximum-units-on-a-truck/
*/

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int answer = 0;
        Arrays.sort(boxTypes, (x, y) -> y[1] - x[1]);           // 박스 별 unit 기준으로 내림차순 정렬
        for (int[] type : boxTypes) {
            if (type[0] >= truckSize) {                         // 트럭 공간이 모자를 경우
                answer += type[1] * truckSize;                  // 남은 수량만큼만 answer에 더하고 break
                break;
            }

            truckSize -= type[0];
            answer += type[0] * type[1];
        }

        return answer;
    }
}

/*
Runtime: 7 ms, faster than 91.13% of Java online submissions for Maximum Units on a Truck.
Memory Usage: 38.8 MB, less than 97.20% of Java online submissions for Maximum Units on a Truck.
*/
