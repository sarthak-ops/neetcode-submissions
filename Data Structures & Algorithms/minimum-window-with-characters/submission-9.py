class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t): return ""
        map1 = {}
        for i in range(len(t)):
            map1[t[i]] = map1.get(t[i], 0) + 1
        left = 0
        need = len(t)
        ans = ""
        for right in range(len(s)):
            if s[right] in map1:
                if map1[s[right]] > 0:
                    need -= 1
                map1[s[right]] -= 1
            while need == 0:
                if ans == "" or len(s[left: right+1]) < len(ans):
                    ans = s[left: right+1]
                if s[left] in map1:
                    map1[s[left]] += 1
                    if map1[s[left]] > 0:
                        need += 1
                left += 1
        return ans

        