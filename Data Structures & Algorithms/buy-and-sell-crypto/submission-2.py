class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minv = prices[0]
        maxp = -2**31
        for i in range(1, len(prices)):
            p = prices[i] - minv
            maxp = max(maxp, p)
            minv = min(minv, prices[i])
        return 0 if maxp < 0 else maxp