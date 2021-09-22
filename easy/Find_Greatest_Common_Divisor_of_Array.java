'''
1979.
Find Greatest Common Divisor of Array
https://leetcode.com/problems/find-greatest-common-divisor-of-array/
'''

import java.lang.Math;

class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return gcd(nums[0], nums[nums.length-1]);
    }
    
    private int gcd(int a, int b) {
        if (a > b) {        // a <= b가 되도록 정렬
            int temp = a;
            a = b;
            b = temp;
        }
        
        Deque<Integer> deq = new LinkedList<>();        // 크기가 작은 divisor들을 담을 deque
        for (int i = 1; i <= (int) Math.sqrt(a); i++) {
            if (a % i > 0) {
                continue;
            }
            
            deq.addLast(i);             // 아래의 divisor에 비해 크기가 작지만 i도 divisor에 해당되므로 deq에 담아서 필요시에 사용
            int divisor = a / i;
            if (b % divisor == 0) {
                return divisor;
            }
        }
        
        while (!deq.isEmpty()) {        // 큰 divisor에서 gcd가 발견되지 않으면 deq에 있는 작은 divisor에서 gcd를 찾아야함
            int pop = deq.removeLast();
            if (b % pop == 0) {
                return pop;
            }
        }
        
        return 1;
    }
}

'''
Runtime: 2 ms, faster than 38.29% of Java online submissions for Find Greatest Common Divisor of Array.
Memory Usage: 38.7 MB, less than 77.61% of Java online submissions for Find Greatest Common Divisor of Array.
'''
