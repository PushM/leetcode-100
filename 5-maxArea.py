class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        就是一个贪心+双指针吧
        双指针：从左右往中间走
        贪心：对应的高度较小的那个指针不可能再作为容器的边界了（左右指针，谁高度小谁走）
        """
        l, r = 0, len(height)-1
        ans = 0
        while l < r :
            area = min(height[l],height[r]) * (r - l)
            ans = max(ans,area)
            if height[l] > height[r] :
                r -= 1
            else:
                l += 1
        return ans