'''
929.
Unique Email Addresses
https://leetcode.com/problems/unique-email-addresses/
'''

class Solution:
    def numUniqueEmails(self, emails: list(str)) -> int:
        filtered = []
        
        for e in emails:
            [local, domain] = e.split('@')              # @을 기준으로 분리
            if '+' in local:                            # 로컬 네임에서 + 이후의 문자는 삭제
                local = local[:local.index('+')]
            
            filteredLocal = "".join(filter(lambda x: x != '.', local))      # 로컬 네임에서 . 문자는 삭제
            filtered.append("@".join([filteredLocal, domain]))              # 필터링된 최종 주소를 저장
        
        return len(set(filtered))

'''
Runtime: 60 ms, faster than 39.39% of Python3 online submissions for Unique Email Addresses.
Memory Usage: 14.4 MB, less than 33.59% of Python3 online submissions for Unique Email Addresses.
'''