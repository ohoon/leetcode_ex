/**
1122.
Relative Sort Array
https://leetcode.com/problems/relative-sort-array/
**/

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        
        List<Integer> arrList1 = new ArrayList<>(arr1.length);
        for (int x : arr1) {
            arrList1.add(x);
        }
        
        Collections.sort(arrList1, (x, y) -> {
                if (map.get(x) != null && map.get(y) != null) {
                    return map.get(x) - map.get(y);
                }
                    
                if (map.get(x) != null) {
                    return -1;
                }
                
                if (map.get(y) != null) {
                    return 1;
                }
                    
                return x - y;
        });
        
        for (int i = 0; i < arrList1.size(); i++) {
            arr1[i] = arrList1.get(i);
        }
        
        return arr1;
    }
}

/*
Runtime: 48 ms, faster than 95.66% of Python3 online submissions for Binary Tree Tilt.
Memory Usage: 16.4 MB, less than 6.05% of Python3 online submissions for Binary Tree Tilt.
*/

/*
다른 사람의 풀이

public int[] relativeSortArray(int[] arr1, int[] arr2) {
    //create map for counting numbers in arr1. Initialize everything with zeroes
    Map<Integer, Integer> m = new HashMap();
    for (int num : arr2) {
        m.put(num, 0);
    }
    int last = arr1.length - 1;
    int[] res = new int[arr1.length];
    //iterate over arr1  and count numbers of time this element is in arr1
    for (int num : arr1) {
        //if number is from arr2 - increment count
        if (m.containsKey(num))
            m.put(num, m.get(num) + 1);
        //otherwise add element to the end of res and decrement the pointer
        else {
            res[last--] = num;
        }
    }
    //iterate over arr2, fill elements in res based on it's count 
    int p = 0;
    for (int num : arr2) {
        int c = m.get(num);
        for (int i = 0; i < c; i++) {
            res[p++] = num;
        }
    }
    //now sort the leftovers - p points to the first element in series of those from arr2 that are not in arr1 
    Arrays.sort(res, p, res.length);
    return res;
}

comparator sorting이 아닌 각 문자가 나온 횟수만큼 해시맵 value를 누적시켜 나중에 해당 value만큼 문자를 반복하여 저장하는 방법을 사용했다.
아무래도 sorting이 아니기 때문에 시간복잡도는 O(N)으로 나의 코드보다 효율적이라고 생각된다.
java로 코딩문제를 풀어본 것은 처음이라 인터넷도 많이 뒤져보고 풀이도 참고했는데,
빨리 익숙해져서 문제 푸는 속도를 줄여야겠음

*/
