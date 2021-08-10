/*
77.
Combinations
https://leetcode.com/problems/combinations/
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        combination(n, k, 1, new ArrayList<Integer>(), answer);
        return answer;
    }
    
    private void combination(int n, int k, int current, List<Integer> list, List<List<Integer>> answer) {
        if (list.size() == k) {         // k개를 모두 골랐으면 answer에 추가하고 종료
            answer.add(new ArrayList(list));
            return;
        }
        
        if (current > n) {              // n을 벗어나면 종료
            return;
        }
        
        list.add(current);
        combination(n, k, current + 1, list, answer);       // 해당 숫자를 선택한 경우
        list.remove(list.size() - 1);
        combination(n, k, current + 1, list, answer);       // 해당 숫자를 선택하지 않은 경우
    }
}

/*
Runtime: 20 ms, faster than 38.74% of Java online submissions for Combinations.
Memory Usage: 40.6 MB, less than 32.57% of Java online submissions for Combinations.
*/

/*
다른 사람의 풀이

class Solution {
    public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		combine(combs, new ArrayList<Integer>(), 1, n, k);
		return combs;
	}
	public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
		if(k==0) {
			combs.add(new ArrayList<Integer>(comb));
			return;
		}
		for(int i=start;i<=n;i++) {
			comb.add(i);
			combine(combs, comb, i+1, n, k-1);
			comb.remove(comb.size()-1);
		}
	}
}

선택하지 않는 상황을 for문을 통해서 해결한 풀이다.
나의 풀이의 경우는 순회를 하나 더 거쳐서 선택하지 않는 상황을 해결했는데, 순회를 많이 쓰면 스택에 부담이 크기 때문에 k 크기에 제한이 걸릴 가능성이 크다.
따라서 for문으로 불필요한 순회를 하지 않도록 하는 것이 더 좋은 것 같다.

*/
