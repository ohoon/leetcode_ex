/*
2121.
Intervals Between Identical Elements
https://leetcode.com/problems/intervals-between-identical-elements/
*/

class Solution {
    public long[] getDistances(int[] arr) {
        long[] answer = new long[arr.length];
        Map<Integer, Long> sumMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!sumMap.containsKey(arr[i])) {
                sumMap.put(arr[i], 0l);
                countMap.put(arr[i], 0);
            }
            
            answer[i] += i * (long)countMap.get(arr[i]) - sumMap.get(arr[i]);
            sumMap.put(arr[i], sumMap.get(arr[i]) + i);
            countMap.put(arr[i], countMap.get(arr[i]) + 1);
        }
        
        sumMap = new HashMap<>();
        countMap = new HashMap<>();
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            if (!sumMap.containsKey(arr[i])) {
                sumMap.put(arr[i], 0l);
                countMap.put(arr[i], 0);
            }
            
            answer[i] += (len - i - 1) * (long)countMap.get(arr[i]) - sumMap.get(arr[i]);
            sumMap.put(arr[i], sumMap.get(arr[i]) + (len - i - 1));
            countMap.put(arr[i], countMap.get(arr[i]) + 1);
        }
        
        return answer;
    }
}

/*
Runtime: 403 ms, faster than 10.79% of Java online submissions for Intervals Between Identical Elements.
Memory Usage: 265.4 MB, less than 12.50% of Java online submissions for Intervals Between Identical Elements.
*/

/*
여담

내가 시도한 방법은 해시맵 하나를 써서 각 숫자별로 나온 인덱스를 누적시켜가면서 arr의 앞부터 탐색하는 방법이었다.
전에 나왔던 인덱스가 존재하면 인덱스 차이만큼 그 이전 인덱스의 값과 현재 인덱스의 값에 더해줬는데,
최악의 경우에 O(N^2)의 시간복잡도를 가지는 좋지 않은 코드였다.
다른 사람은 이 문제를 어떻게 해결했을까 찾아보니 조금 특이하고 기발한 아이디어가 있어서 가져왔다.
이 코드를 작성한 사람은 약간 수학적으로 풀었는데, 같은 값을 가지는 인덱스의 위치가 a, b, c라고 예를 들면
c 기준으로 a, b와의 차이는 |c-a| + |c-b|이다. 이것을 풀어서 계산하면 2c - (a+b)이고,
이를 공식으로 만들면 (자신을 제외한 인덱스의 개수) * (현재 인덱스) - (자신을 제외한 인덱스의 합)으로 나타낼 수 있다.
위 공식의 전제 조건은 c가 a, b보다 커야하고 c 이후의 d, e 인덱스의 경우에는 배열을 거꾸로 뒤집어서 적용하면 해결된다.

*/
