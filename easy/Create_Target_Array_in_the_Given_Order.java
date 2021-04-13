/*
1389.
Create Target Array in the Given Order
https://leetcode.com/problems/create-target-array-in-the-given-order/
*/

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            answer.add(index[i], nums[i]);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

/*
Runtime: 3 ms, faster than 10.12% of Java online submissions for Create Target Array in the Given Order.
Memory Usage: 37.4 MB, less than 63.67% of Java online submissions for Create Target Array in the Given Order.
*/

/*
다른 사람의 풀이

public int[] createTargetArray(int[] nums, int[] index) {
     int[] target = new int[nums.length];
     int i = 0, k = 0;
	 while (i < index.length) {
		for (k = target.length - 1; k > index[i]; k--)
			target[k] = target[k - 1];
		target[index[i]] = nums[i];
		i++;
	}
    return target;
}

arraylist를 사용하지 않고 array로 푼 풀이
확실히 list보다 array로 풀이하는 것이 속도가 빠른듯하다.
하지만 가독성과 개발성을 생각하면 조금의 속도를 감수하고 list를 사용하는게 더 나은 것 같다.

*/
