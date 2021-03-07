'''
953.
Verifying an Alien Dictionary
https://leetcode.com/problems/verifying-an-alien-dictionary/
'''

class Solution:
    def isAlienSorted(self, words: list(str), order: str) -> bool:
        return words == sorted(words, key=lambda word: [order.index(digit) for digit in word])      # 각 digit의 order index 값을 key로 정렬하여 전/후가 다르면 False

'''
Runtime: 44 ms, faster than 23.74% of Python3 online submissions for Verifying an Alien Dictionary.
Memory Usage: 14.4 MB, less than 52.38% of Python3 online submissions for Verifying an Alien Dictionary.
'''

'''
다른 풀이

class Solution(object):
    def isAlienSorted(self, words, order):
        order_index = {c: i for i, c in enumerate(order)}

        for i in xrange(len(words) - 1):
            word1 = words[i]
            word2 = words[i+1]

            # Find the first difference word1[k] != word2[k].
            for k in xrange(min(len(word1), len(word2))):
                # If they compare badly, it's not sorted.
                if word1[k] != word2[k]:
                    if order_index[word1[k]] > order_index[word2[k]]:
                        return False
                    break
            else:
                # If we didn't find a first difference, the
                # words are like ("app", "apple").
                if len(word1) > len(word2):
                    return False

        return True

나의 경우에는 sort 함수를 이용해서 풀이했는데, 이 방법은 출제자가 원하는 방법도 아니고 무조건 전체를 sorting하기 때문에 시간 복잡도도 비효율적이라고 볼 수 있다.
아마도 정석 풀이는 위의 풀이처럼 해시 테이블을 먼저 만들고 인접한 두 단어를 첫 단어부터 비교하며 아닌 경우를 찾으면 바로 False를 반환하도록 하는 코드일 것이다.

'''