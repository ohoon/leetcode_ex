/*
31.
Next Permutation
https://leetcode.com/problems/next-permutation/
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Next Permutation.
Memory Usage: 39.3 MB, less than 43.41% of Java online submissions for Next Permutation.
*/

/*
여담

처음에 시도한 방법은 nums를 복사한 arr을 오름차순으로 정렬하여 순열의 시작점을 구한 뒤에
순열을 직접 시도하면서 nums와 같은 순열이 나오면 다음 순열을 진행한 후에 코드를 종료하도록 구현하려고 했었다.
이 과정에서 재귀를 사용해서 풀다보니 nums 순열을 발견하면 다음 순열까지만 진행하고 프로그램을 멈추는 과정 구현이 너무 어려웠다.
boolean 변수를 파라미터로 받아서 처리할까 생각도 했지만 이미 스택에 쌓인 함수들이 있기 때문에 소용이 없을 것이라 생각되었다.
결국 일단 해답을 보고 이해를 해서 다음에는 솔루션과 같은 방식으로 풀이해야겠다.

*/
