class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        totalmax = nums[0]
        cursum = 0
        for x in nums:
            cursum = max(cursum, 0)
            cursum += x
            totalmax = max(cursum, totalmax)
        return totalmax
