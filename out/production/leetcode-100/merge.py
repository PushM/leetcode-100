class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        intervals.sort(key = lambda x: x[0])

        ans = []
        for interval in intervals:
            if ans == [] or interval[0] > ans[-1][1] :
                ans.append(interval)
            else:
                ans[-1][1] = max(ans[-1][1], interval[1])
        return ans
        #虽然很简单，但这是用到了贪心把，要证明这样比较得到的就是正确的。