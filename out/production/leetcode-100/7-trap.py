class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        分析得到：每个i处的盛水的面积等于 min(leftmax,rightmax)-height[i]

        盛水的题想到双指针。
        """
        left, right = 0, len(height)-1
        leftMax, rightMax = height[left], height[right]
        ans = 0

        while left < right :
            if leftMax < rightMax :
                ans += (leftMax - height[left])
                left += 1
                leftMax = max(height[left], leftMax)
            else:
                ans += (rightMax - height[right])
                right -= 1
                rightMax = max(height[right], rightMax)
                
        return ans

        