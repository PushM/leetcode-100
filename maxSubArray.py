class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        pre = nums[0] ; maxAns = nums[0]
        for i in range(1, len(nums)):
            pre = max(pre + nums[i], nums[i])
            maxAns = max(maxAns, pre)
        return maxAns   
"""
#f(i)=max{f(i−1)+nums[i],nums[i]}
主要考虑 nums[i]单独成为一段还是加入 f(i−1) 对应的那一段
"""
