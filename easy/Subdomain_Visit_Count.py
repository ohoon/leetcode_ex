'''
811.
Subdomain Visit Count
https://leetcode.com/problems/subdomain-visit-count/
'''

class Solution:
    def subdomainVisits(self, cpdomains: list(str)) -> list(str):
        hash_map = {}
        for count_paired_domain in cpdomains:
            [count, domain] = count_paired_domain.split()           # 숫자와 도메인 분리
            elems = domain.split('.')
            for i in range(len(elems)):
                address = ".".join(elems[i:])                       # 도메인을 서브 주소들로 분리해서 작업. 같은 서브 주소인 것들은 숫자가 합해짐
                hash_map[address] = int(count) if address not in hash_map else hash_map[address] + int(count)
        
        return [str(value) + ' ' + key for (key, value) in hash_map.items()]

'''
Runtime: 52 ms, faster than 73.87% of Python3 online submissions for Subdomain Visit Count.
Memory Usage: 14.4 MB, less than 41.48% of Python3 online submissions for Subdomain Visit Count.
'''