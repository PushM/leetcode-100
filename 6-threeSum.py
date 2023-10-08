class Solution2(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ans = []
        n = len(nums)
        nums.sort()
        i = 0 ; j = 1 ; k = 2
        while i < n-2  :
            if i>0 and nums[i-1] == nums[i]:
                i += 1; j = i + 1; k = j + 1                
                continue 
            while j < n-1 :
                if j-1 != i and nums[j-1] == nums[j]:
                    j += 1; k = j + 1                
                    continue 
                while k < n :
                    if k-1 != j and nums[k-1] == nums[k]:
                        k+=1                
                        continue                     
                    if nums[i] + nums[j] + nums[k] == 0 :
                       ans.append([nums[i], nums[j], nums[k]])
                    k+=1
                j += 1
                k = j+1
            i += 1; j = i + 1; k = j + 1
        return ans
class Solution(object):
    def threeSum(self, nums):
        """
        test
        :type nums: List[int]
        :rtype: List[List[int]]
        两点：
        （1）不重复，直接排序后判断和前一个元素是不是一样
        （2）「双指针」，当我们需要枚举数组中的两个元素时，如果我们发现随着第一个元素的递增，第二个元素是递减的，
        那么就可以使用双指针的方法，将枚举的时间复杂度从O(N^2)减少至 O(N)。

        """
        ans = []
        n = len(nums)
        nums.sort()
        for i in range(n):
            if i > 0 and nums[i] == nums[i-1] :
                i += 1
                continue
            target = -nums[i]  #把问题分解转化，把三数之和转化为找两数之和（找递增数列的两数之和有双指针技巧）
            k = n-1
            for j in range(i+1, n):
                if j > i+1 and nums[j] == nums[j-1]:
                    j += 1
                    continue
                while j < k and nums[k] + nums[j] > target:#知道nums[k] + nums[j]不大于target或者右指针k左移到了j的位置
                    k -= 1
                if j == k:#如果双指针重复，说明j固定，k--时始终nums[k] + nums[j]> target ; j再增大也不会出现nums[k] + nums[j]，所以跳出j的循环
                    break
                if nums[k] + nums[j] == target:#如果恰好=target，记录下来，这个j就找完了，再去找下一个j。
                    ans.append([nums[i], nums[j], nums[k]])    

        return ans
nums = [0,0,0]
sol = Solution()
print(sol.threeSum(nums))   

