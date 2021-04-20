/*
1460.
Make Two Arrays Equal by Reversing Sub-arrays
https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
*/

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : target) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        
        for (int num : arr) {
            if (!map.containsKey(num) || map.get(num) < 1) {
                return false;
            }
            
            map.put(num, map.get(num) - 1);
        }
        
        return true;
    }
}

/*
Runtime: 5 ms, faster than 26.48% of Java online submissions for Make Two Arrays Equal by Reversing Sub-arrays.
Memory Usage: 38.9 MB, less than 58.37% of Java online submissions for Make Two Arrays Equal by Reversing Sub-arrays.
*/

/*
다른 사람의 풀이

public boolean canBeEqual(int[] target, int[] arr) {
	int[] countMap = new int[1001]; //Map that holds count of ints

	//Iterate through the arrays
	for(int i = 0; i < target.length; i++) {
		countMap[target[i]]++; //Increment count of int found in target array
		countMap[arr[i]]--; //Decrement count of int found in arr array
	}

	//Iterate countMap
	for(int i : countMap) {
		//If not 0, it means target and arr do not match
		if(i != 0) {
			return false; //Return false
		}
	}

	//If this point is reached, the arrays are equal
	return true;
}

역시 해시맵 대신에 배열로 풀이한 것이 속도가 빠른듯하다.
하지만 input이 어떻게 들어올지 모를땐 해시맵이 더 나은 것 같아 배열 풀이쪽은 손이 잘 안간다..
정말 속도가 필요할때만 배열을 이용해서 풀도록 하자.

*/
