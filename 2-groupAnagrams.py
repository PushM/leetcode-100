import collections
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        mp = collections.defaultdict(list) #https://www.cnblogs.com/herbert/archive/2013/01/09/2852843.html
        #mp的形式是{key:[list]}
        for str in strs:
            key = ''.join(sorted(str))
            mp[key].append(str)
        
        return list(mp.values())

strs = ["eat","tea","tan","ate","nat","bat"]
print(Solution().groupAnagrams(strs))