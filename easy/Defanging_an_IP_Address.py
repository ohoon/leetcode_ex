'''
1108.
Defanging an IP Address
https://leetcode.com/problems/defanging-an-ip-address/
'''

class Solution:
    def defangIPaddr(self, address: str) -> str:
        return address.replace('.', '[.]')

'''
Runtime: 20 ms, faster than 98.98% of Python3 online submissions for Defanging an IP Address.
Memory Usage: 14.4 MB, less than 37.14% of Python3 online submissions for Defanging an IP Address.
'''
