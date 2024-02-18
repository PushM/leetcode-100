"""
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回 滑动窗口中的最大值 。

示例 1：

输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
示例 2：

输入：nums = [1], k = 1
输出：[1]
 
提示：
1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
"""
import heapq
import collections
class Solution1:
    def maxSlidingWindow(self, nums: list[int], k: int) -> list[int]:
        n = len(nums)
        # 从第前k个元素中构建最小堆
        heapTmp = [(-nums[i], i) for i in range(k)]
        heapq.heapify(heapTmp)
        #遍历 k到n，首先剔除最左边的元素（但这里是最小堆不是队列，只能判断堆顶元素的下标是不是小于右边元素的下标）
        #，之后入新加的右边的元素，然后记录堆顶元素到ans数组
        ans = [-heapTmp[0][0]]
        for i in range(k, n):
            while heapTmp[0][1] < i-k: #应该是小于判断堆顶元素的下标是不是小于*左元素*的下标（i-k）
                heapq.heappop(heapTmp)
            heapq.heappush(heapTmp, (-nums[i], i))
            ans.append(-heapTmp[0][0])
        #返回ans数据
        return ans

        """
         heapq.heapify：heapq.heapify 是 Python 中 heapq 模块提供的一个函数，用于将一个列表转化为堆
         heapq.heappush
         heapq.heappop
        """
class Solution2:
    def maxSlidingWindow(self, nums: list[int], k: int) -> list[int]:
        #nums数组前k个元素先构建单调队列，队列存什么呢？
        #新加一个值，如果值小于队列的队尾元素，值就入队
        #如果值大于队列的队尾元素，就删去队尾的元素，因为这个元素在新加元素的左边，只要新加元素在，这个元素肯定不是滑动窗口的最大值了，所以可以删去
        #collections.deque双端队列，collections.queue队列
        #注意队列存的是元素的下标，不像前面的最小堆，下标和元素一起存了。最小堆能自动帮你排序，所以要传入元素的值
        n = len(nums)
        q = collections.deque()
        for i in range(k):
            while q and nums[i] > nums[q[-1]]:
                q.pop()#pop是清理队尾元素，就是右边的元素
            q.append(i)
        ans = [nums[q[0]]]        
        #之后遍历nums中k到n的元素，进行新加元素到队尾的操作，但也要注意在pop最大值时要清理滑动窗口左边的还在队列中的元素。
        for i in range(k, n):
            while q and nums[i] > nums[q[-1]]:
                q.pop()
            q.append(i)
            while q[0] <= i-k:#这里必须是<=,i=k时i-k=0，if q[0]=0就要pop掉
                q.popleft()#pop是清理队首元素，就是最左边的元素
            ans.append(nums[q[0]])
        return ans

nums = [1,-1]
k = 1
print(Solution2().maxSlidingWindow(nums, k))