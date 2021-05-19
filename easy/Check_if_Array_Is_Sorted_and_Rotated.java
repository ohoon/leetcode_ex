/*
1752.
Check if Array Is Sorted and Rotated
https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
*/

class Solution {
    public boolean check(int[] nums) {
        boolean isRotated = false;          // rotated된 배열인지
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                if (isRotated) {            // 이미 rotated된 배열임에도 불구하고 예외값이 존재하면 false 반환
                    return false;
                }

                isRotated = true;
            }
        }

        return !isRotated || nums[0] >= nums[nums.length - 1];      // rotated되었다면 nums[0]은 nums[-1]보다 무조건 작거나 같아야함
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Check if Array Is Sorted and Rotated.
Memory Usage: 36.7 MB, less than 23.71% of Java online submissions for Check if Array Is Sorted and Rotated.
*/

/*
다른 사람의 풀이

class Solution {
    public boolean check(int[] nums) {
        // here we compare all the neighbouring elemnts and check whether they are in somewhat sorted
        // there will be a small change due to rotation in the array at only one place.
        // so if there are irregularities more than once, return false
        // else return true;
        int irregularities = 0;
        int length = nums.length;
        for (int i=0; i<length; i++) {
            if (nums[i] > nums[(i + 1) % length])
                irregularities += 1;
        }
        return irregularities > 1 ? false : true;
    }
}

이 풀이는 나의 풀이처럼 복잡하게 boolean 변수를 사용할 필요도 없이
예외값 개수를 세어서 2개 이상이면 잘못된 입력이라고 쉽게 판단할 수 있다.
조금 더 생각했으면 깔끔한 코드를 작성할 수 있었는데 아쉽다.

*/
