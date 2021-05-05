/*
1636.
Sort Array by Increasing Frequency
https://leetcode.com/problems/sort-array-by-increasing-frequency/
*/

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        
        List<Integer> answer = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(answer, (n1, n2) -> map.get(n1) == map.get(n2) ? n2 - n1 : map.get(n1) - map.get(n2));
        return answer.stream().mapToInt(i -> i).toArray();
    }
}

/*
Runtime: 12 ms, faster than 12.03% of Java online submissions for Sort Array by Increasing Frequency.
Memory Usage: 38.8 MB, less than 86.76% of Java online submissions for Sort Array by Increasing Frequency.
*/

/*
다른 사람의 풀이

public int[] frequencySort(int[] nums) {
	Map<Integer, Integer> map = new HashMap<>();
	// count frequency of each number
	Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
	// custom sort
	return Arrays.stream(nums).boxed()
			.sorted((a,b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
			.mapToInt(n -> n)
			.toArray();
}

풀이 과정은 같지만 비효율적으로 stream 분해해서 조립하는 과정을 줄여 최적화한 것 같다.
내 코드가 시간이 꽤 걸려서 다른 방법이 있나 궁금했는데 최적화가 덜 됐음을 알게됐다.

*/
