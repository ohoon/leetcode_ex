'''
204.
Count Primes
https://leetcode.com/problems/count-primes/
'''

class Solution:
    def countPrimes(self, n: int) -> int:
        primes = set(range(2, n))
        sqrt = int(n ** 0.5)
        for i in range(2, sqrt + 1):
            if i not in primes:
                continue
                
            for j in range(i ** 2, n, i):
                if j in primes:
                    primes -= set([j])

        return len(primes)

'''
Runtime: 1200 ms, faster than 26.49% of Python3 online submissions for Count Primes.
Memory Usage: 183.2 MB, less than 5.02% of Python3 online submissions for Count Primes.
'''

'''
다른 사람의 풀이

    def countPrimes(self, n: int) -> int:
        if n < 3: return 0     ###// No prime number less than 2
        lst = [1] * n          ###// create a list for marking numbers less than n
        lst[0] = lst[1] = 0    ###// 0 and 1 are not prime numbers
        m = 2
        while m * m < n:       ###// we only check a number (m) if its square is less than n
            if lst[m] == 1:    ###// if m is already marked by 0, no need to check its multiples.
			
			    ###// If m is marked by 1, we mark all its multiples from m * m to n by 0. 
			    ###// 1 + (n - m * m - 1) // m is equal to the number of multiples of m from m * m to n
                lst[m * m: n: m] = [0] *(1 + (n - m * m - 1) // m)
				
			###// If it is the first iteration (e.g. m = 2), add 1 to m (e.g. m = m + 1; 
			### // which means m will be 3 in the next iteration), 
            ###// otherwise: (m = m + 2); This way we avoid checking even numbers again.	
            m += 1 if m == 2 else 2
        return sum(lst)

로직은 동일한데 set의 차집합으로 prime이 아닌 수를 제거하는 것이 아니라
배열 요소를 0으로 바꾸게하는 것으로 prime이 아님을 나타냈다.
set와 배열 사용의 차이가 이렇게 시간 차이가 날줄은 몰랐다.
set로 하면 1200ms의 시간이 걸리는 반면에, 배열로 푸니까 124ms의 시간 밖에 안걸렸다.
lst[m*m:n:m]처럼 m 간격의 요소를 동시에 수정할 수 있는 방법도 여기서 처음 보고 놀랬다.
range()에서만 쓰이는줄 알았는데 배열에서도 가능하단 것을 배웠다.

'''