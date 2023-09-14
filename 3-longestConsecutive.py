class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums_set = set(nums)
        longestSeq = 0
        for x in nums_set:   
            if x-1 in nums_set :   # not in
                continue
            else:
                x_longestSeq = 1
                
                while x+1 in nums_set:
                    x+=1
                    x_longestSeq += 1

                if x_longestSeq > longestSeq :  #max()
                    longestSeq = x_longestSeq
        return longestSeq


l = [100,4,200,1,3,2]
sol = Solution()
print(sol.longestConsecutive(l))


"""
哈希表，一个是set、一个是字典
查set和查字典，都是O(1)
"""