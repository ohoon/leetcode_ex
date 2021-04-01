/*
1287.
Element Appearing More Than 25% In Sorted Array
https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
*/

class Solution {
    public int findSpecialInteger(int[] arr) {
        int target = (int) Math.ceil(arr.length / 4.0);         // 전체 길이의 25%
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {                           // 연속되는 숫자의 경우 count 증가
                count++;
            } else {                                            // 새로운 숫자가 나오면 count 초기화
                count = 1;
            }
            
            if (count > target) {                               // 목표치를 초과하면 해당 요소 반환
                return arr[i];
            }
        }
        
        return arr[0];                                          // arr 사이즈가 1인 경우
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Element Appearing More Than 25% In Sorted Array.
Memory Usage: 39.6 MB, less than 25.90% of Java online submissions for Element Appearing More Than 25% In Sorted Array.
*/

/*
다른 사람의 풀이

public int findSpecialInteger(int[] arr) {
    if (arr.length == 1) return arr[0];

    int length = arr.length;
    List<Integer> firstThreeQuarters =
            new ArrayList<>(Arrays.asList(arr[length / 4], arr[length / 2], arr[3 * length / 4]));

    for (Integer elem : firstThreeQuarters) {
        int pos = firstOccurrence(arr, elem);
        if (arr[pos + length / 4] == elem)
            return elem;
    }
    return -1;
}

private int firstOccurrence(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;
    while (start < end) {
        int mid = start + (end - start) / 2;
        if (target > arr[mid])
            start = mid + 1;
        else
            end = mid;
    }
    return end;
}

arr을 4분할로 나눈 위치에 해당하는 요소가 언제 처음 나타나는지 이진탐색으로 알아내어 처음 나타나는 위치에서 length / 4 다음 위치에도 똑같은 요소가 나타나면
빈도수가 25% 초과한 것으로 보고 반환하는 알고리즘이다. 이진탐색만을 이용하기 때문에 시간복잡도는 O(logN)으로 상당히 빠른 편이다.

*/
