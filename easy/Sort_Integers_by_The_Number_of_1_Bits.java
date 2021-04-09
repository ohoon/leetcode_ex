/*
1356.
Sort Integers by The Number of 1 Bits
https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
*/

class Solution {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
            .boxed()            // Integer 랩퍼 클래스로 박싱
            .sorted((Integer a1, Integer a2) -> {
                int c1 = Integer.bitCount(a1);      // 1bit의 개수
                int c2 = Integer.bitCount(a2);
                
                if (c1 == c2) {
                    return a1 - a2;                 // 1bit의 개수가 동일하면 원래 숫자를 비교
                } else {                            // 다르면 1bit의 개수가 작은 것부터 정렬
                    return c1 - c2;
                }
            })
            .mapToInt(Integer::intValue)            // int 타입으로 매핑
            .toArray();
    }
}

/*
Runtime: 9 ms, faster than 55.48% of Java online submissions for Sort Integers by The Number of 1 Bits.
Memory Usage: 39.4 MB, less than 69.97% of Java online submissions for Sort Integers by The Number of 1 Bits.
*/

/*
다른 사람의 풀이

class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int result[] = new int[n];
		// Sort based on the hamming weight 
		// and if the hamming weight is same then sort it based on its integer value
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    int w1 = hammingWt(a);
                    int w2 = hammingWt(b);
                    if (w1 == w2) {
                        return a - b;
                    }
                    return w1 - w2;
                }
            });
       
        int ind = 0;
        for (int i = 0; i < n; i++) {
            minHeap.add(arr[i]); 
        }
        while (minHeap.size() > 0) {
            int num = minHeap.poll();
            result[ind++] = num;
        }
        return result;
    }
    
	// Calculate the hamming weight for each Integer
    private int hammingWt(int num) {
        int wt = 0;
        while (num > 0) {
            wt++;
            num = num & (num - 1);
        }
        return wt;
    }
}

일반적인 sort의 comparator을 사용한 풀이가 아니라 heap sort을 이용한 풀이다.
heap sort와 merge sort 중에 뭐가 더 효율적인가를 따지면 아무래도 전체적인 정렬 상태를 나타내는 것은 merge sort쪽이 유리하다고 생각이 든다.
heap sort는 k번째로 작은 수와 같은 경우에 효율적이라고 생각함
1비트의 개수를 세는 것도 hamming 기법을 이용한 것을 볼 수 있다.
해밍기법을 처음 본 것은 아닌데 기억이 잘 나지 않아 이 풀이를 보고 다시 생각났다.
bitCount 함수 대신에 해밍기법을 사용하는 것도 고려해

*/
