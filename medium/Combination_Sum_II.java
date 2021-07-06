/*
40.
Combination Sum II
https://leetcode.com/problems/combination-sum-ii/
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);        // combination 중복 제거를 위한 정렬
        sub(candidates, 0, target, false, new ArrayList<>(), answer);
        return answer;
    }
    
    public void sub(int[] candidates, int i, int target, boolean flag, List<Integer> result, List<List<Integer>> answer) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {          // 타겟을 만족하는 combi가 나오면 answer에 추가
            answer.add(new ArrayList(result));
            return;
        }
        
        if (i < candidates.length) {
            if (i > 0 && candidates[i-1] == candidates[i] && !flag) {       // 이전 candidate와 중복된 수가 나왔고 이전에는 선택되지 않았으면 이번의 경우도 선택되지 않아야 중복이 생기지 않음
                sub(candidates, i + 1, target, false, result, answer);
                return;
            }
            
            result.add(candidates[i]);
            sub(candidates, i + 1, target - candidates[i], true, result, answer);       // 선택된 경우
            result.remove(result.size() - 1);
            sub(candidates, i + 1, target, false, result, answer);                      // 선택되지 않은 경우
        }
    }
}

/*
Runtime: 4 ms, faster than 65.00% of Java online submissions for Combination Sum II.
Memory Usage: 39.4 MB, less than 45.24% of Java online submissions for Combination Sum II.
*/

/*
여담

중복에 대한 조건이 없었던 컴비네이션1 문제에 비해서 중복을 제거해야 하는 조건이 추가되면서
로직이 좀더 까다로워졌다고 느껴졌다.
중복된 숫자가 나온지 확인하기 위해 우선 candidates 배열을 정렬하였고
이전 숫자와 현재 숫자를 비교하여 중복된 숫자가 나왔음을 판단하고, oox oxo xoo와 같이 중복된 combi가 나오는 것을 방지하기 위해서
이전 숫자가 선택되지 않으면 이후의 숫자도 선택하지 않도록 하여 중복을 방지했다. (oxo와 xoo의 경우, 선택되지 않은 숫자 이후에는 선택될 수 없어야하므로 성립하지 않음)

*/
