class Solution(object):
    def twoSum(self, nums:list[int], target:int) -> list[int] :
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hashtable = dict()
        for i, num in enumerate(nums):
            if target - num in hashtable:
                return [i, hashtable[target - num]]
            else:
                hashtable[num] = i
    

nums = [2,7,11,15] ; target = 9
sol = Solution()
print(sol.twoSum(nums,target))