'''
374.
Guess Number Higher or Lower
https://leetcode.com/problems/guess-number-higher-or-lower/
'''

def guess(n: int) -> int:
    print('The guess API is already defined for you.')
    
class Solution:
    def guessNumber(self, n: int) -> int:
        left, right = 1, n
        while left <= right:            # binary-search
            mid = (left + right) // 2
            if guess(mid) == 1:
                left = mid + 1
                continue
            
            if guess(mid) == -1:
                right = mid
                continue
            
            return mid

'''
Runtime: 28 ms, faster than 67.36% of Python3 online submissions for Guess Number Higher or Lower.
Memory Usage: 14.3 MB, less than 6.80% of Python3 online submissions for Guess Number Higher or Lower.
'''

'''
다른 풀이

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0)
                return mid1;
            if (res2 == 0)
                return mid2;
            else if (res1 < 0)
                high = mid1 - 1;
            else if (res2 > 0)
                low = mid2 + 1;
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;
    }
}

binary search말고 ternary search라는 방법을 사용한 풀이다.
아예 다른 방식은 아니고 2진탐색이 범위를 절반으로 쪼갠다면 ternary 탐색은 범위를 동일한 셋으로 쪼갠다는 차이가 있다.
따라서 시간복잡도는 O(log3 N)으로 더 빠른 결과를 구할 수 있다고 볼 수 있지만
최악의 경우에 2진 탐색은 1 + 2log2 N에 비해 Ternary 탐색은 1 + 4log3 N으로 log2 N : 2log3 N 의 시간비가 나오게 된다.
따라서 여러 경우에서 실질적 시간은 2진 탐색이 더 빠른 것을 알 수 있다.

'''