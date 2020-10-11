'''
9.
Palindrome Number
https://leetcode.com/problems/palindrome-number/
'''

class Solution:
    def isPalindrome(self, x: int) -> bool:
        num = []
        
        if (x < 0):
            return False
        
        if (x == 0):
            return True
        
        while (x != 0):
            num.append(x % 10)      # 일의 자리부터 배열에 추가
            x //= 10            # 다음 자리의 수로
        
        for i in range(len(num) // 2):      # 숫자의 절반까지 탐색
            if (num[i] != num[-(i + 1)]):       # 좌우대칭이 아니면 False
                return False
        
        return True

'''
Runtime: 64 ms, faster than 60.93% of Python3 online submissions for Palindrome Number.
Memory Usage: 14.2 MB, less than 100.00% of Python3 online submissions for Palindrome Number.
'''

'''
다른 사람의 풀이

class Solution:
    def isPalindrome(self, x: int) -> bool:
        num = 0
        
        if (x == 0):
            return True
        
        if (x < 0 or x % 10 == 0):
            return False
        
        while (x > num):
            num = num * 10 + x % 10
            x //= 10
        
        return x == num or x == num//10

Follow up 조건에 주어진 숫자를 문자열화해서 풀지 말라고 명시되어 있어서
나는 숫자를 일의자리부터 하나씩 뽑아서 배열에 넣고 배열의 길이로 숫자 자리 수를 알아내서 푸는 방법을 택했다.
하지만 위의 풀이는 숫자 자리 수를 빼낸 자리 수를 뒤집고 그 숫자가 빼낸 나머지 숫자보다 크면 중단하는 것으로
숫자의 중간지점을 알 수 있도록 했다. 이런 아이디어를 생각하지 못한게 좀 아쉽다.
시간 복잡도도 숫자 전부를 탐색하지 않기 때문에 내 코드의 절반가량일 것이다.

'''