class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        occ = set()
        maxlen = 0
        #occ.add(s[0])  case：s=""就会报错
        r = 0
        for l in range(n): 
            if l != 0:
                set.remove(s[l-1])
            while r < n and s[r] not in occ:
                occ.add(s[r])
                r+=1
            maxlen = max(maxlen,len(occ))
        return maxlen