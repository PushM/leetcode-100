class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        left = 0 ; right = 0 
        while right < n :
            if nums[left] != 0:
                nums[right],nums[left] = nums[left],nums[right]
                left +=1
            right+=1
        print(nums)
        '''
        左指针对应着0序列的第一个0  左指针左边均为非零数；
        右指针对应着0序列后的第一个元素    右指针左边直到左指针处均为零。
        
        双指针
        '''
l = [0,1,0,3,12]
sol = Solution()
print(sol.moveZeroes(l))        