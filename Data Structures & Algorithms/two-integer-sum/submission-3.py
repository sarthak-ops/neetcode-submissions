class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i in range(len(nums)):
            wi = target - nums[i]
            if wi in map:
                return [map.get(wi), i]
            map[nums[i]] = i
        return [-1, -1]