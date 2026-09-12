class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        hmap = {}
        l = 0
        maxc = 0
        maxf = 0
        for r in range(len(s)):
            hmap[s[r]] = hmap.get(s[r], 0) + 1
            maxf = max(maxf, hmap[s[r]])
            while (r - l + 1) - maxf > k:
                hmap[s[l]] = hmap.get(s[l], 0) - 1
                l+=1
            maxc = max(maxc, r - l + 1)
        return maxc
