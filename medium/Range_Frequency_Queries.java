/*
2080.
Range Frequency Queries
https://leetcode.com/problems/range-frequency-queries/
*/

class RangeFreqQuery {

    private Map<Integer, List<Integer>> map;        // key = 각 숫자, value = key가 위치한 인덱스 들의 list
    
    private double binarySearch(List<Integer> list, int val) {      // 일반적인 2진 탐색과 다르게 해당 값의 존재유무에 따라 인덱스 값을 정수형(.0) 또는 실수형(.5)으로 반환
        int L = 0, R = list.size();
        while (L < R) {
            int M = (L + R) / 2;
            if (list.get(M) < val) {
                L = M + 1;
            } else if (list.get(M) > val) {
                R = M;
            } else {        // 정확히 val에 맞는 인덱스가 나오면 .0으로 반환
                return (double) M;
            }
        }
        
        return L - 0.5;     // 대강의 위치만 나오면 .5로 반환
    }
    
    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {      // arr의 요소 별로 map 구축
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(arr[i], list);
            }
        }
    }
    
    public int query(int left, int right, int value) {
        if (!map.containsKey(value)) {      // arr에 없는 value의 결과는 무조건 0
            return 0;
        }
        
        List<Integer> list = map.get(value);
        return (int) Math.floor(binarySearch(list, right)) - (int) Math.ceil(binarySearch(list, left)) + 1;     // left의 경우에는 올림, right의 경우에는 내림하여 인덱스 차이 계산
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */

/*
Runtime: 371 ms, faster than 27.63% of Java online submissions for Range Frequency Queries.
Memory Usage: 140.8 MB, less than 31.58% of Java online submissions for Range Frequency Queries.
*/
