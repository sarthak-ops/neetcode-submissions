class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        seen = set()
        for _ in nums:
            if _ in seen:
                return True
            seen.add(_)
        return False