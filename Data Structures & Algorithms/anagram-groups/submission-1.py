class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = {}
        for i in range(len(strs)):
            s = "".join(sorted(strs[i]))
            if s not in map:
                map[s] = []
            map[s].append(strs[i])
        return list(map.values())