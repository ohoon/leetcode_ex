/*
46.
Permutations
https://leetcode.com/problems/permutations/
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        sub(answer, nums, 0);
        return answer;
    }
    
    private void sub(List<List<Integer>> answer, int[] arr, int index) {
        if (index == arr.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            
            answer.add(list);
            return;
        }
        
        sub(answer, arr, index + 1);
        for (int i = index + 1; i < arr.length; i++) {
            swap(arr, index, i);
            sub(answer, arr, index + 1);
            swap(arr, index, i);
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
Runtime: 1 ms, faster than 92.91% of Java online submissions for Permutations.
Memory Usage: 39.2 MB, less than 67.89% of Java online submissions for Permutations.
*/

/*
다른 사람의 풀이

class Solution {
    public List<List<Integer>> permute(int[] letters) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(), new boolean[letters.length], res, letters);
        return res;
    }

    private static void dfs(List<Integer> path, boolean[] used, List<List<Integer>> res, int[] letters) {
        if (path.size() == used.length) {
            // make a deep copy since otherwise we'd be append the same list over and over
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < used.length; i++) {
            // skip used letters
            if (used[i]) continue;
            // add letter to permutation, mark letter as used
            path.add(letters[i]);
            used[i] = true;
            dfs(path, used, res, letters);
            // remove letter from permutation, mark letter as unused
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }    
}

나의 경우에는 swap을 이용해서 재귀적으로 풀이했고
해당 풀이의 경우에는 boolean array를 하나 만들어서 이 원소가 선택됐는지 안됐는지 알 수 있게끔 하여 풀이했다.
시간복잡도는 비슷하지만 공간복잡도를 생각하면 내 풀이가 in-place로 swap하여 풀기 때문에 효율적이라고 생각한다.

*/
