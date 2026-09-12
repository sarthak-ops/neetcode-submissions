class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2): return False
        map1 = {}
        map2 = {}
        left = 0
        for i in range(len(s1)):
            map1[s1[i]] = map1.get(s1[i], 0) + 1
        for right in range(len(s2)):
            if right - left + 1 > len(s1):
                map2[s2[left]] = map2.get(s2[left], 0) - 1
                if map2[s2[left]] == 0: del map2[s2[left]]
                left+=1
            map2[s2[right]] = map2.get(s2[right], 0) + 1
            if map1 == map2: return True
        return False

